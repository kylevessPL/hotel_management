package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.utils.DateParam;
import pl.piasta.hotel.domain.rooms.utils.SortParam;

import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRoomsWithinDateRange(DateParam dateParam, SortParam sortParam);

}
