package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class BookingAlreadyConfirmedException extends BookingException {

    public BookingAlreadyConfirmedException() {
        super("B12", "Booking already confirmed");
    }

}
