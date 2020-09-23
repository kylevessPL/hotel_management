package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domain.model.bookings.utils.BookingCancellationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingFinalDetails;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;

import java.util.List;
import java.util.Optional;

public interface BookingsRepository {

    List<Integer> getBookingsRoomIdBetweenDates(DateDetails dateDetails);
    Integer saveBookingAndGetId(BookingDetails booking);
    void saveBookingConfirmation(Integer bookingId);
    Optional<BookingConfirmationDetails> getBookingConfirmationDetails(Integer bookingId);
    Optional<BookingFinalDetails> getBookingFinalDetails(Integer bookingId);
    Optional<BookingCancellationDetails> getBookingCancellationDetails(Integer bookingId);
    void cancelBooking(Integer bookingId);

}
