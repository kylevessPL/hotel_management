package pl.piasta.hotel.domain.model.bookings.utils;

public class BookingAlreadyConfirmedException extends Exception {

    public BookingAlreadyConfirmedException() {
        super("Booking already confirmed");
    }

    public BookingAlreadyConfirmedException(String message) {
        super(message);
    }

}
