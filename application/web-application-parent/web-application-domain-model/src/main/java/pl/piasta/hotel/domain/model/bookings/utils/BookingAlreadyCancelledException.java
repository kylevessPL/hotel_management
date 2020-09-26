package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class BookingAlreadyCancelledException extends BookingException {

    public BookingAlreadyCancelledException() {
        super("B09", "Booking already cancelled");
    }

}
