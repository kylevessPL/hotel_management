package pl.piasta.hotel.domain.rooms;

import pl.piasta.hotel.domainmodel.rooms.Room;
import pl.piasta.hotel.domainmodel.rooms.RoomDetails;
import pl.piasta.hotel.domainmodel.rooms.RoomFinalDetails;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RoomsRepository {

    List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate);
    Optional<RoomDetails> getRoomDetails(Integer roomId);
    RoomFinalDetails getRoomFinalDetails(Integer roomId);

}
