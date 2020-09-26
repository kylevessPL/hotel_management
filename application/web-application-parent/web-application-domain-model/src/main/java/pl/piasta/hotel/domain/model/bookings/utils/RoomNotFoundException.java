package pl.piasta.hotel.domain.model.bookings.utils;

import pl.piasta.hotel.domain.model.utils.BookingException;

public class RoomNotFoundException extends BookingException {

    public RoomNotFoundException() {
        super("R04", "Room not found");
    }

}
