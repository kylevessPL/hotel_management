package pl.piasta.hotel.domain.model.bookings.utils;

public class RoomNotFoundException extends Exception {

    public RoomNotFoundException() {
        super("Room not found");
    }

    public RoomNotFoundException(String message) {
        super(message);
    }

}
