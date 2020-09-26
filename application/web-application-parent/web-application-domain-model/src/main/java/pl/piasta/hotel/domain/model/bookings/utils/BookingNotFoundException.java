package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class BookingNotFoundException extends BookingException {

    public BookingNotFoundException() {
        super("B04", "Booking not found");
    }

}
