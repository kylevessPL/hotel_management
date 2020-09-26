package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class RoomNotAvailableException extends BookingException {

    public RoomNotAvailableException() {
        super("R12", "Room not available");
    }

}
