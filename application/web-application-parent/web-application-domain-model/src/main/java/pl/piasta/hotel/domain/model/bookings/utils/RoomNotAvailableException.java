package pl.piasta.hotel.domain.model.bookings.utils;

public class RoomNotAvailableException extends Exception {

    public RoomNotAvailableException() {
        super("Room not available");
    }

    public RoomNotAvailableException(String message) {
        super(message);
    }

}
