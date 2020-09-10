package pl.piasta.hotel.domain.model.bookings.utils;

public class PaymentFormNotFoundException extends Exception {

    public PaymentFormNotFoundException() {
        super("Payment form not found");
    }

    public PaymentFormNotFoundException(String message) {
        super(message);
    }

}
