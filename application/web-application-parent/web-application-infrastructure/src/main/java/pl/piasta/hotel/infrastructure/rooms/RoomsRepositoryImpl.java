package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.rooms.mapper.RoomsEntityMapper;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityMapper roomsEntityMapper;
    private final RoomsEntityDao dao;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate, Pageable pageable) {
        return roomsEntityMapper.mapToRoom(dao.findAllAvailableWithinDateRange(startDate, endDate, pageable));
    }

}
