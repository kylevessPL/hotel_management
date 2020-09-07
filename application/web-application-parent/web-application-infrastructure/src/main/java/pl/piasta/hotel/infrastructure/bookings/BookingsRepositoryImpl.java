package pl.piasta.hotel.infrastructure.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.bookings.BookingsRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;
import pl.piasta.hotel.infrastructure.dao.AmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.dao.CustomersEntityDao;
import pl.piasta.hotel.infrastructure.dao.PaymentFormsEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomAmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.AdditionalServicesEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.BookingsEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.CustomersEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.PaymentFormsEntityMapper;
import pl.piasta.hotel.infrastructure.mapper.RoomsEntityMapper;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;
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
    private final CustomersEntityMapper customersEntityMapper;
    private final AdditionalServicesEntityMapper additionalServicesMapper;
    private final RoomsEntityMapper roomsEntityMapper;
    private final BookingsEntityDao bookingsDao;
    private final RoomsEntityDao roomsDao;
    private final AmenitiesEntityDao amenitiesDao;
    private final RoomAmenitiesEntityDao roomAmenitiesDao;
    private final PaymentFormsEntityDao paymentFormsDao;
    private final AdditionalServicesEntityDao additionalServicesDao;
    private final CustomersEntityDao customersDao;

    @Override
    public List<Integer> getBookingsRoomIdBetweenDates(Date startDate, Date endDate) {
        return bookingsDao.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate)
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
        RoomsEntity room = roomsDao.findById(roomId).orElseThrow(EntityNotFoundException::new);
        List<Integer> amenityId = roomAmenitiesDao.findAll()
                .stream()
                .filter(e -> e.getRoomId().equals(roomId))
                .map(RoomAmenitiesEntity::getAmenityId)
                .collect(Collectors.toList());
        List<AmenitiesEntity> amenities = amenitiesDao.findAll()
                .stream()
                .filter(e -> amenityId.contains(e.getId()))
                .collect(Collectors.toList());
        return roomsEntityMapper.mapToRoom(room, amenities);
    }

    @Override
    public Customer getCustomerByDocumentId(String documentId) {
        return customersEntityMapper.mapToCustomer(customersDao.findByDocumentId(documentId));
    }

    @Override
    public List<AdditionalService> getAdditionalServices(String[] additionalServices) {
        List<String> services = Arrays.stream(additionalServices).collect(Collectors.toList());
        return additionalServicesMapper.mapToAdditionalService(additionalServicesDao.findAll()
                .stream()
                .filter(e -> services.contains(e.getName()))
                .collect(Collectors.toList()));
    }

    @Override
    public void saveBooking(
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
        Integer id = getCustomerByDocumentId(documentId).getId();
        if(id != null) {
            customersEntityMapper.updateEntity(id, customer);
        }
        customersDao.save(customer);
        bookingsDao.save(bookingsEntityMapper.createEntity(
                startDate,
                endDate,
                customer.getId(),
                roomId,
                finalPrice));
    }

}
