package pl.piasta.hotel.domain.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.customers.CustomersRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingDetails;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.domain.model.customers.utils.CustomerDetails;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.domain.model.rooms.utils.RoomDetails;
import pl.piasta.hotel.domain.paymentforms.PaymentFormsRepository;
import pl.piasta.hotel.domain.rooms.RoomsRepository;

import java.math.BigDecimal;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository bookingsRepository;
    private final AdditionalServicesRepository additionalServicesRepository;
    private final CustomersRepository customersRepository;
    private final RoomsRepository roomsRepository;
    private final PaymentFormsRepository paymentFormsRepository;

    @Override
    @Transactional
    public Booking bookAndGetSummary(BookingCommand bookingCommand) {
        RoomDetails roomDetails = getRoomDetails(bookingCommand.getRoomId(), bookingCommand.getDateDetails());
        List<AdditionalService> additionalServicesList = getAdditionalServices(bookingCommand.getAdditionalServices());
        List<PaymentForm> paymentFormList = getPaymentForms();
        BigDecimal finalPrice = calculateFinalPrice(roomDetails, additionalServicesList, bookingCommand.getDateDetails());
        Integer customerId = saveCustomerAndGetId(bookingCommand.getCustomerDetails());
        Integer bookingId = saveBookingAndGetId(bookingCommand.getDateDetails(), roomDetails, finalPrice, customerId);
        return getBookingSummary(paymentFormList, finalPrice, bookingId);
    }

    private Booking getBookingSummary(List<PaymentForm> paymentFormList, BigDecimal finalPrice, Integer bookingId) {
        return new Booking(bookingId, finalPrice, paymentFormList);
    }

    private Integer saveCustomerAndGetId(CustomerDetails customerDetails) {
        return customersRepository.saveCustomerAndGetId(customerDetails);
    }

    private Integer saveBookingAndGetId(DateDetails dateDetails, RoomDetails roomDetails, BigDecimal finalPrice, Integer customerId) {
        BookingDetails bookingDetails = createBookingDetails(dateDetails, roomDetails, finalPrice, customerId);
        return bookingsRepository.saveBookingAndGetId(bookingDetails);
    }

    private BookingDetails createBookingDetails(DateDetails dateDetails, RoomDetails roomDetails, BigDecimal finalPrice, Integer customerId) {
        return new BookingDetails(
                dateDetails,
                customerId,
                roomDetails,
                finalPrice);
    }

    private List<PaymentForm> getPaymentForms() {
        return paymentFormsRepository.getAllPaymentForms();
    }

    private List<AdditionalService> getAdditionalServices(Integer[] additionalServices) {
        return additionalServicesRepository.getAllAdditionalServices(
                Arrays.stream(additionalServices).collect(Collectors.toList()))
                .orElseThrow(AdditionalServiceNotFoundException::new);
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
        long period = Period.between(
                dateDetails.getStartDate().toLocalDate(),
                dateDetails.getEndDate().toLocalDate())
                .getDays();
        BigDecimal roomPrice = roomDetails.getStandardPrice();
        BigDecimal additionalServicesPrice = additionalServicesList
                .stream()
                .map(AdditionalService::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return roomPrice.add(additionalServicesPrice).multiply(new BigDecimal(period));
    }

}
