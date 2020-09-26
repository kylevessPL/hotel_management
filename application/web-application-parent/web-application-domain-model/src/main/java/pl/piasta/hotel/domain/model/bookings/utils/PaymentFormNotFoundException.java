package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class PaymentFormNotFoundException extends BookingException {

    public PaymentFormNotFoundException() {
        super("P04", "Payment form not found");
    }

}
