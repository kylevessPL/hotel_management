package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.RoomCommand;

import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRoomsWithinDateRange(RoomCommand roomCommand);

}
