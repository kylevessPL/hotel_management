package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityDao dao;

    @Override
    public List<Room> getAllRooms() {
        return dao.findAll().stream()
                .map(entity -> new Room(entity.getId(), entity.getBedAmount(), entity.getStandardPrice()))
                .collect(Collectors.toList());
    }

}
