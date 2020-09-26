package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class AdditionalServiceNotFoundException extends BookingException {

    public AdditionalServiceNotFoundException() {
        super("AS04", "Additional service not found");
    }

}
