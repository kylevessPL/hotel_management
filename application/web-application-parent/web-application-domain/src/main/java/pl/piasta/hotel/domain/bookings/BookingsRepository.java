package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookingsRepository {

    List<Integer> getBookingsRoomIdBetweenDates(Date startDate, Date endDate);
    List<PaymentForm> getAllPaymentForms();
    Room getRoomById(Integer roomId);
    Customer getCustomerByDocumentId(String documentId);
    List<AdditionalService> getAdditionalServices(String[] additionalServices);
    void saveBooking(
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
            BigDecimal finalPrice
    );

}
