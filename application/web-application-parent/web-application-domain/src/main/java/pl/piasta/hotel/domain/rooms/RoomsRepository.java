package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domain.model.rooms.Room;

import java.sql.Date;
import java.util.List;

public interface RoomsRepository {

    List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate);

}
