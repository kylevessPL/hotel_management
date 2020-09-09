package pl.piasta.hotel.domain.model.bookings.utils;

public class AdditionalServiceNotFoundException extends Exception {

    public AdditionalServiceNotFoundException() {
        super("Additional service not found");
    }

    public AdditionalServiceNotFoundException(String message) {
        super(message);
    }

}
