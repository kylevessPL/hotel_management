package pl.piasta.hotel.domain.rooms;

import org.springframework.data.domain.Pageable;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.util.List;

public interface RoomsService {

    List<Room> getAllAvailableRooms(Pageable pageable);

}
