package pl.piasta.hotel.domain.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.customers.utils.CustomerParam;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.DateParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository repository;

    @Override
    public Booking bookAndGetSummary(
            Integer roomId,
            String[] additionalServices,
            CustomerParam customerParam,
            DateParam dateParam) throws RoomNotAvailableException {
        Date startDate = dateParam.getStartDate();
        Date endDate = dateParam.getEndDate();
        if(!isRoomAvailable(roomId, startDate, endDate)) {
            throw new RoomNotAvailableException();
        }

        Room room = repository.getRoomById(roomId);
        List<AdditionalService> additionalServicesList = repository.getAdditionalServices(additionalServices);
        List<PaymentForm> paymentForms = repository.getAllPaymentForms();
        BigDecimal finalPrice = calculateFinalPrice(room, additionalServicesList, startDate, endDate);
        repository.saveBooking(
                startDate,
                endDate,
                customerParam.getFirstName(),
                customerParam.getLastName(),
                customerParam.getStreetName(),
                customerParam.getHouseNumber(),
                customerParam.getZipCode(),
                customerParam.getCity(),
                customerParam.getDocumentType(),
                customerParam.getDocumentId(),
                roomId,
                finalPrice
        );
        Customer customer = repository.getCustomerByDocumentId(customerParam.getDocumentId());
        return new Booking(
                customer,
                room,
                additionalServicesList,
                startDate,
                endDate,
                finalPrice,
                paymentForms
        );
    }

    private boolean isRoomAvailable(Integer roomId, Date startDate, Date endDate) {
        return !repository.getBookingsRoomIdBetweenDates(startDate, endDate).contains(roomId);
    }

    private BigDecimal calculateFinalPrice(Room room, List<AdditionalService> additionalServices, Date startDate, Date endDate) {
        long nights = Duration.between(startDate.toLocalDate(), endDate.toLocalDate()).toDays();
        BigDecimal roomPrice = room.getStandardPrice();
        BigDecimal additionalServicesPrice = additionalServices
                .stream()
                .map(AdditionalService::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return roomPrice.add(additionalServicesPrice).multiply(new BigDecimal(nights));
    }

}
