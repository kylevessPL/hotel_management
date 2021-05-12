package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domainmodel.rooms.Room;
import pl.piasta.hotel.domainmodel.rooms.RoomCommand;

import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRoomsWithinDateRange(RoomCommand roomCommand);

}
