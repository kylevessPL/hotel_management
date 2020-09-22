package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationCommand;

public interface BookingsService {

    Booking bookAndGetSummary(BookingCommand bookingCommand);
    void confirmBooking(BookingConfirmationCommand bookingConfirmationCommand);

}
