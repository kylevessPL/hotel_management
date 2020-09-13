package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.domain.model.rooms.utils.SortDetails;

import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRoomsWithinDateRange(DateDetails dateDetails, SortDetails sortDetails);

}
