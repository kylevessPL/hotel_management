package pl.piasta.hotel.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository repository;

    @Override
    public List<Room> getAllAvailableRooms(Pageable pageable) {
        return repository.getAllAvailableRooms(pageable);
    }

}
