package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domain.model.rooms.Room;

import java.util.List;

public interface RoomsRepository {

    List<Room> getAllRooms();

}
