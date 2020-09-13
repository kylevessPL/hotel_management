package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domain.model.bookings.utils.BookingDetails;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;

import java.util.List;

public interface BookingsRepository {

    List<Integer> getBookingsRoomIdBetweenDates(DateDetails dateDetails);
    Integer saveBookingAndGetId(BookingDetails booking);
    void savePayment(
            Integer bookingId,
            Integer paymentFormId,
            String transationId
    );
    void saveBookingConfirmation(Integer bookingId);

}
