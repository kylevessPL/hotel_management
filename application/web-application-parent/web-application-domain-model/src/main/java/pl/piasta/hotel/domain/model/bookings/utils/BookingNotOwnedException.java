package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class BookingNotOwnedException extends BookingException {

    public BookingNotOwnedException() {
        super("B14", "Booking not owned");
    }

}
