package pl.piasta.hotel.domain.rooms;

import org.springframework.data.domain.Pageable;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.sql.Date;
import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate, Pageable pageable);

}
