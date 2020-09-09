package pl.piasta.hotel.domain.model.bookings.utils;

public class BookingNotFoundException extends Exception {

    public BookingNotFoundException() {
        super("Booking not found");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }

}
