package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class BookingExpiredException extends BookingException {

    public BookingExpiredException() {
        super("B13", "Booking expired");
    }

}
