package pl.piasta.hotel.domain.model.bookings.utils;

public class BookingExpiredException extends Exception {

    public BookingExpiredException() {
        super("Booking already expired");
    }

    public BookingExpiredException(String message) {
        super(message);
    }

}
