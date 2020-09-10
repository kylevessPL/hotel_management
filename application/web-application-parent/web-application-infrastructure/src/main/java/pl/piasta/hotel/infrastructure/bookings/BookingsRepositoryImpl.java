package pl.piasta.hotel.infrastructure.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.bookings.BookingsRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.bookings.BookingDate;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;
import pl.piasta.hotel.infrastructure.dao.AmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.BookingsConfirmedEntityDao;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.dao.CustomersEntityDao;
import pl.piasta.hotel.infrastructure.dao.PaymentFormsEntityDao;
import pl.piasta.hotel.infrastructure.dao.PaymentsEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomAmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.AdditionalServicesEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.BookingsConfirmedEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.BookingsEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.CustomersEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.PaymentFormsEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.PaymentsEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.RoomsEntityMapper;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.BookingsConfirmedEntity;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;
import pl.piasta.hotel.infrastructure.model.PaymentFormsEntity;
import pl.piasta.hotel.infrastructure.model.PaymentsEntity;
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookingsRepositoryImpl implements BookingsRepository {

    private final PaymentFormsEntityMapper paymentFormsEntityMapper;
    private final BookingsEntityMapper bookingsEntityMapper;
    private final BookingsConfirmedEntityMapper bookingsConfirmedEntityMapper;
    private final CustomersEntityMapper customersEntityMapper;
    private final AdditionalServicesEntityMapper additionalServicesMapper;
    private final RoomsEntityMapper roomsEntityMapper;
    private final PaymentsEntityMapper paymentsEntityMapper;
    private final BookingsEntityDao bookingsDao;
    private final BookingsConfirmedEntityDao bookingsConfirmedDao;
    private final RoomsEntityDao roomsDao;
    private final AmenitiesEntityDao amenitiesDao;
    private final RoomAmenitiesEntityDao roomAmenitiesDao;
    private final PaymentFormsEntityDao paymentFormsDao;
    private final PaymentsEntityDao paymentsDao;
    private final AdditionalServicesEntityDao additionalServicesDao;
    private final CustomersEntityDao customersDao;

    @Override
    public List<Integer> getBookingsRoomIdBetweenDates(Date startDate, Date endDate) {
        return bookingsDao.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate)
                .stream()
                .map(BookingsEntity::getRoomId)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentForm> getAllPaymentForms() {
        return paymentFormsEntityMapper.mapToPaymentForm(paymentFormsDao.findAll());
    }

    @Override
    public Room getRoomById(Integer roomId) {
        RoomsEntity room;
        try {
            room = roomsDao.findById(roomId).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException ex) {
            return null;
        }
        List<RoomAmenitiesEntity> roomAmenities = roomAmenitiesDao.findAllByRoomId(roomId);
        List<AmenitiesEntity> amenities = amenitiesDao.findAllByIdIn(roomAmenities
                .stream()
                .map(RoomAmenitiesEntity::getAmenityId)
                .distinct()
                .collect(Collectors.toList()));
        return roomsEntityMapper.mapToRoom(room, amenities);
    }

    @Override
    public BookingDate getBookingDateById(Integer bookingId) {
        BookingsEntity booking;
        try {
            booking = bookingsDao.findById(bookingId).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException ex) {
            return null;
        }
        return bookingsEntityMapper.mapToBookingDate(booking);
    }

    @Override
    public Customer getCustomerByDocumentId(String documentId) {
        CustomersEntity customer;
        try {
            customer = customersDao.findByDocumentId(documentId).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException ex) {
            return null;
        }
        return customersEntityMapper.mapToCustomer(customer);
    }

    @Override
    public Integer getBookingsConfirmedIdByBookingId(Integer bookingId) {
        BookingsConfirmedEntity bookingConfirmed;
        try {
            bookingConfirmed = bookingsConfirmedDao.findByBookingId(bookingId).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException ex) {
            return null;
        }
        return bookingConfirmed.getId();
    }

    @Override
    public Integer getPaymentFormIdByName(String paymentForm) {
        PaymentFormsEntity paymentFormsEntity;
        try {
            paymentFormsEntity = paymentFormsDao.findByName(paymentForm).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException ex) {
            return null;
        }
        return paymentFormsEntity.getId();
    }

    @Override
    public List<AdditionalService> getAdditionalServices(String[] additionalServices) {
        List<String> services = Arrays.stream(additionalServices).collect(Collectors.toList());
        List<AdditionalServicesEntity> additionalServicesList = additionalServicesDao.findAll()
                .stream()
                .filter(e -> services.contains(e.getName()))
                .collect(Collectors.toList());
        if(additionalServicesList.isEmpty()) {
            return null;
        }
        return additionalServicesMapper.mapToAdditionalService(additionalServicesList);
    }

    @Override
    public Integer saveBookingAndGetId(
            Date startDate,
            Date endDate,
            String firstName,
            String lastName,
            String streetName,
            String houseNumber,
            String zipCode,
            String city,
            String documentType,
            String documentId,
            Integer roomId,
            BigDecimal finalPrice) {
        CustomersEntity customer = customersEntityMapper.createEntity(
                firstName,
                lastName,
                streetName,
                houseNumber,
                zipCode,
                city,
                documentType,
                documentId
        );
        Customer oldCustomer = getCustomerByDocumentId(documentId);
        if(oldCustomer != null) {
            customersEntityMapper.updateEntity(oldCustomer.getId(), customer);
        }
        customer = customersDao.saveAndFlush(customer);
        BookingsEntity newBooking = bookingsDao.saveAndFlush(bookingsEntityMapper.createEntity(
                startDate,
                endDate,
                customer.getId(),
                roomId,
                finalPrice));
        return newBooking.getId();
    }

    @Override
    public void savePayment(Integer bookingId, Integer paymentFormId, String transationId) {
        PaymentsEntity payment = paymentsEntityMapper.createEntity(
                bookingId,
                paymentFormId,
                transationId
        );
        paymentsDao.saveAndFlush(payment);
    }

    @Override
    public void saveBookingConfirmation(Integer bookingId) {
        BookingsConfirmedEntity bookingConfirmed = bookingsConfirmedEntityMapper.createEntity(bookingId);
        bookingsConfirmedDao.saveAndFlush(bookingConfirmed);
    }

}
