package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domainmodel.bookings.Booking;
import pl.piasta.hotel.domainmodel.bookings.BookingCancellationCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingConfirmationCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingInfo;

public interface BookingsService {

    Booking bookAndGetSummary(BookingCommand bookingCommand);
    BookingInfo getBookingInfo(Integer id);
    void confirmBooking(BookingConfirmationCommand bookingConfirmationCommand);
    void cancelBooking(BookingCancellationCommand bookingCancellationCommand);

}
