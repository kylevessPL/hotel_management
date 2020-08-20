package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.RoomsEntityMapper;

import java.sql.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityMapper roomsEntityMapper;
    private final RoomsEntityDao roomsDao;
    private final BookingsEntityDao bookingsDao;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate) {
        List<Integer> bookedRooms = bookingsDao.findRoomIdBetweenDates(startDate, endDate);
        return roomsEntityMapper.mapToRoom(bookedRooms.isEmpty() ? roomsDao.findAll() : roomsDao.findByIdNotIn(bookedRooms));
    }

}
