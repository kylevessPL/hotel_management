package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.AmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomAmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.RoomsEntityMapper;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityMapper roomsEntityMapper;
    private final RoomsEntityDao roomsDao;
    private final BookingsEntityDao bookingsDao;
    private final RoomAmenitiesEntityDao roomAmenitiesDao;
    private final AmenitiesEntityDao amenitiesDao;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate) {
        List<Integer> bookedRooms = bookingsDao.findRoomIdBetweenDates(startDate, endDate);
        List<RoomsEntity> roomsEntities = bookedRooms.isEmpty() ? roomsDao.findAll() : roomsDao.findByIdNotIn(bookedRooms);
        List<Room> rooms = new ArrayList<>();
        roomsEntities.forEach(roomsEntity -> {
            List<Integer> amenitiesIds = roomAmenitiesDao.findAmenitiesIdsByRoomId(roomsEntity.getId());
            List<AmenitiesEntity> amenitiesEntities = amenitiesIds.stream().map(amenityId -> amenitiesDao.findById(amenityId).orElseThrow(EntityNotFoundException::new)).collect(Collectors.toList());
            rooms.add(roomsEntityMapper.mapToRoom(roomsEntity, amenitiesEntities));
        });
        return rooms;
    }

}
