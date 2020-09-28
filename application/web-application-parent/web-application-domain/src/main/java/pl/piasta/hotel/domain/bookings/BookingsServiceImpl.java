package pl.piasta.hotel.domain.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.bookingsservices.BookingsServicesRepository;
import pl.piasta.hotel.domain.customers.CustomersRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.BookingDate;
import pl.piasta.hotel.domain.model.bookings.BookingInfo;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyCancelledException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyConfirmedException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCancellationCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCancellationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingExpiredException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingFinalDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotOwnedException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingStatus;
import pl.piasta.hotel.domain.model.bookings.utils.PaymentFormNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.domain.model.customers.utils.CustomerDetails;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.payments.utils.PaymentDetails;
import pl.piasta.hotel.domain.model.payments.utils.PaymentStatus;
import pl.piasta.hotel.domain.model.rooms.RoomInfo;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.domain.model.rooms.utils.RoomDetails;
import pl.piasta.hotel.domain.model.rooms.utils.RoomFinalDetails;
import pl.piasta.hotel.domain.paymentforms.PaymentFormsRepository;
import pl.piasta.hotel.domain.payments.PaymentsRepository;
import pl.piasta.hotel.domain.rooms.RoomsRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;
    private final AdditionalServicesRepository additionalServicesRepository;
    private final BookingsServicesRepository bookingsServicesRepository;
    private final CustomersRepository customersRepository;
    private final RoomsRepository roomsRepository;
    private final PaymentFormsRepository paymentFormsRepository;
    private final PaymentsRepository paymentsRepository;

    @Override
    @Transactional
    public Booking bookAndGetSummary(BookingCommand bookingCommand) {
        RoomDetails roomDetails = getRoomDetails(bookingCommand.getRoomId(), bookingCommand.getDateDetails());
        List<AdditionalService> additionalServicesList = getAdditionalServices(bookingCommand.getAdditionalServices());
        List<PaymentForm> paymentFormList = getPaymentForms();
        BigDecimal finalPrice = calculateFinalPrice(roomDetails, additionalServicesList, bookingCommand.getDateDetails());
        Integer customerId = saveCustomerAndGetId(bookingCommand.getCustomerDetails());
        Integer bookingId = saveBookingAndGetId(bookingCommand.getDateDetails(), roomDetails, finalPrice, customerId);
        saveBookingServices(bookingId, additionalServicesList);
        return createBookingSummary(paymentFormList, finalPrice, bookingId);
    }

    @Override
    @Transactional
    public void confirmBooking(BookingConfirmationCommand bookingConfirmationCommand) {
        Integer bookingId = bookingConfirmationCommand.getBookingId();
        Integer paymentFormId = bookingConfirmationCommand.getPaymentFormId();
        String transactionId = bookingConfirmationCommand.getTransactionId();
        BookingConfirmationDetails bookingConfirmationDetails = getBookingConfirmationDetails(bookingId);
        checkBookingValidity(bookingConfirmationDetails.getStatus(), bookingConfirmationDetails.getBookingDate());
        checkPaymentValidity(paymentFormId);
        PaymentDetails paymentDetails = createPaymentFormDetails(bookingId, paymentFormId, transactionId);
        savePayment(paymentDetails);
        saveBookingConfirmation(bookingId);
    }

    @Override
    @Transactional
    public void cancelBooking(BookingCancellationCommand bookingCancellationCommand) {
        Integer bookingId = bookingCancellationCommand.getBookingId();
        String documentId = bookingCancellationCommand.getDocumentId();
        BookingCancellationDetails bookingCancellationDetails = getBookingCancellationDetails(bookingId);
        checkCustomerValidity(bookingCancellationDetails, documentId);
        checkBookingValidity(bookingCancellationDetails.getBookingStatus(), bookingCancellationDetails.getBookingDate());
        cancelBooking(bookingId);
    }

    @Override
    @Transactional(readOnly = true)
    public BookingInfo getBookingInfo(Integer id) {
        BookingFinalDetails bookingFinalDetails = getBookingFinalDetails(id);
        RoomFinalDetails roomFinalDetails = getRoomFinalDetails(bookingFinalDetails.getRoomId());
        PaymentStatus paymentStatus = createPaymentStatus(id, bookingFinalDetails);
        return createBookingInfo(bookingFinalDetails, roomFinalDetails, paymentStatus);
    }

    private BookingInfo createBookingInfo(BookingFinalDetails bookingFinalDetails, RoomFinalDetails roomFinalDetails, PaymentStatus paymentStatus) {
        Date startDate = bookingFinalDetails.getBookingDate().getStartDate();
        Date endDate = bookingFinalDetails.getBookingDate().getEndDate();
        RoomInfo roomInfo = createRoomInfo(roomFinalDetails);
        return new BookingInfo(startDate, endDate, roomInfo, paymentStatus);
    }

    private RoomInfo createRoomInfo(RoomFinalDetails roomFinalDetails) {
        String roomNumber = roomFinalDetails.getRoomNumber();
        Integer bedAmount = roomFinalDetails.getBedAmount();
        List<Amenity> amenities = roomFinalDetails.getAmenities();
        return new RoomInfo(roomNumber, bedAmount, amenities);
    }

    private PaymentStatus createPaymentStatus(Integer bookingId, BookingFinalDetails bookingFinalDetails) {
        BookingStatus bookingStatus = bookingFinalDetails.getBookingStatus();
        PaymentStatus paymentStatus;
        if(bookingStatus.equals(BookingStatus.NOT_CONFIRMED)) {
            paymentStatus = PaymentStatus.NO_PAYMENT_INFO;
        } else if(bookingStatus.equals(BookingStatus.CANCELLED)) {
            paymentStatus = PaymentStatus.BOOKING_CANCELLED;
        } else {
            PaymentForm paymentForm = getBookingPaymentForm(bookingId);
            if(Arrays.asList("Cash", "Check").contains(paymentForm.getName())) {
                paymentStatus = PaymentStatus.UPPON_ARRIVAL;
            } else {
                paymentStatus = PaymentStatus.PAYED;
            }
        }
        return paymentStatus;
    }

    private RoomFinalDetails getRoomFinalDetails(Integer id) {
        return roomsRepository.getRoomFinalDetails(id);
    }

    private BookingFinalDetails getBookingFinalDetails(Integer id) {
        return bookingsRepository.getBookingFinalDetails(id).orElseThrow(BookingNotFoundException::new);
    }

    private BookingCancellationDetails getBookingCancellationDetails(Integer bookingId) {
        return bookingsRepository.getBookingCancellationDetails(bookingId).orElseThrow(BookingNotFoundException::new);
    }

    private PaymentForm getBookingPaymentForm(Integer bookingId) {
        Integer paymentFormId = paymentsRepository.getBookingPaymentFormId(bookingId);
        return paymentFormsRepository.getPaymentForm(paymentFormId);
    }

    private void cancelBooking(Integer bookingId) {
        bookingsRepository.cancelBooking(bookingId);
    }

    private Booking createBookingSummary(List<PaymentForm> paymentFormList, BigDecimal finalPrice, Integer bookingId) {
        return new Booking(bookingId, finalPrice, paymentFormList);
    }

    private void checkCustomerValidity(BookingCancellationDetails bookingCancellationDetails, String documentId) {
        Integer customerId = bookingCancellationDetails.getCustomerId();
        String bookingCustomerDocumentId = customersRepository.getCustomerDocumentId(customerId);
        if(!bookingCustomerDocumentId.equals(documentId)) {
            throw new BookingNotOwnedException();
        }
    }

    private Integer saveCustomerAndGetId(CustomerDetails customerDetails) {
        return customersRepository.saveCustomerAndGetId(customerDetails);
    }

    private Integer saveBookingAndGetId(DateDetails dateDetails, RoomDetails roomDetails, BigDecimal finalPrice, Integer customerId) {
        BookingDetails bookingDetails = createBookingDetails(dateDetails, roomDetails, finalPrice, customerId);
        return bookingsRepository.saveBookingAndGetId(bookingDetails);
    }

    private void saveBookingServices(Integer bookingId, List<AdditionalService> additionalServicesList) {
        if(!additionalServicesList.isEmpty()) {
            List<Integer> additionalServices = additionalServicesList
                    .stream()
                    .map(AdditionalService::getId)
                    .collect(Collectors.toList());
            bookingsServicesRepository.saveBookingServices(bookingId, additionalServices);
        }
    }

    private BookingDetails createBookingDetails(DateDetails dateDetails, RoomDetails roomDetails, BigDecimal finalPrice, Integer customerId) {
        return new BookingDetails(
                dateDetails,
                customerId,
                roomDetails,
                finalPrice
        );
    }

    private List<PaymentForm> getPaymentForms() {
        return paymentFormsRepository.getAllPaymentForms();
    }

    private List<AdditionalService> getAdditionalServices(Integer[] additionalServices) {
        if(additionalServices != null && additionalServices.length > 0) {
            return additionalServicesRepository.getAdditionalServices(Arrays.asList(additionalServices))
                    .orElseThrow(AdditionalServiceNotFoundException::new);
        }
        return Collections.emptyList();
    }

    private RoomDetails getRoomDetails(Integer roomId, DateDetails dateDetails) {
        if(!isRoomAvailable(roomId, dateDetails)) {
            throw new RoomNotAvailableException();
        }
        return roomsRepository.getRoomDetails(roomId).orElseThrow(RoomNotFoundException::new);
    }

    private boolean isRoomAvailable(Integer roomId, DateDetails dateDetails) {
        return !bookingsRepository.getBookingsRoomIdBetweenDates(dateDetails).contains(roomId);
    }

    private BigDecimal calculateFinalPrice(RoomDetails roomDetails, List<AdditionalService> additionalServicesList, DateDetails dateDetails) {
        LocalDate startDate = dateDetails.getStartDate().toLocalDate();
        LocalDate endDate = dateDetails.getEndDate().toLocalDate();
        long period = Period.between(startDate, endDate).getDays();
        BigDecimal roomPrice = roomDetails.getStandardPrice();
        BigDecimal additionalServicesPrice;
        if(!additionalServicesList.isEmpty()) {
            additionalServicesPrice = additionalServicesList
                    .stream()
                    .map(AdditionalService::getPrice)
                    .reduce(ZERO, BigDecimal::add);
        } else {
            additionalServicesPrice = ZERO;
        }
        return roomPrice.add(additionalServicesPrice).multiply(new BigDecimal(period));
    }

    private BookingConfirmationDetails getBookingConfirmationDetails(Integer bookingId) {
        return bookingsRepository.getBookingConfirmationDetails(bookingId).orElseThrow(BookingNotFoundException::new);
    }

    private void checkPaymentValidity(Integer paymentFormId) {
        if(!paymentFormExists(paymentFormId)) {
            throw new PaymentFormNotFoundException();
        }
    }

    private void checkBookingValidity(BookingStatus bookingStatus, BookingDate bookingDate) {
        switch(bookingStatus) {
            case CONFIRMED:
                throw new BookingAlreadyConfirmedException();
            case CANCELLED:
                throw new BookingAlreadyCancelledException();
            default:
                if(!isBookingDateValid(bookingDate)) {
                    throw new BookingExpiredException();
                }
        }
    }

    private boolean isBookingDateValid(BookingDate bookingDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate bookDate = bookingDate.getBookDate().toInstant().atZone(ZoneOffset.UTC).toLocalDate();
        LocalDate startDate = bookingDate.getStartDate().toLocalDate();
        return currentDate.isBefore(startDate) && Period.between(bookDate, currentDate).getDays() <= 14;
    }

    private void saveBookingConfirmation(Integer bookingId) {
        bookingsRepository.saveBookingConfirmation(bookingId);
    }

    private void savePayment(PaymentDetails paymentDetails) {
        paymentsRepository.savePayment(paymentDetails);
    }

    private PaymentDetails createPaymentFormDetails(Integer bookingId, Integer paymentFormId, String transactionId) {
        return new PaymentDetails(bookingId, paymentFormId, transactionId);
    }

    private boolean paymentFormExists(Integer paymentFormId) {
        return paymentFormsRepository.paymentFormExists(paymentFormId);
    }

}
