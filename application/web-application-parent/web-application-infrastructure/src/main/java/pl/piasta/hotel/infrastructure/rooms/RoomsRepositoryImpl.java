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
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityMapper roomsEntityMapper;
    private final RoomsEntityDao roomsDao;
    private final BookingsEntityDao bookingsDao;
    private final RoomAmenitiesEntityDao roomAmenitiesDao;
    private final AmenitiesEntityDao amenitiesEntityDao;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate) {
        List<Integer> bookedRooms = bookingsDao.findRoomIdBetweenDates(startDate, endDate);
        List<RoomsEntity> rooms = bookedRooms.isEmpty() ? roomsDao.findAll() : roomsDao.findByIdNotIn(bookedRooms);
        List<RoomAmenitiesEntity> roomAmenities = roomAmenitiesDao.findAll();
        List<AmenitiesEntity> amenities = amenitiesEntityDao.findAllByIdIn(roomAmenities
                .stream()
                .map(RoomAmenitiesEntity::getAmenityId)
                .distinct()
                .collect(Collectors.toList()));

        TreeMap<Integer, List<AmenitiesEntity>> roomAmenitiesMap = new TreeMap<>();
        rooms.forEach(room -> {
            List<Integer> amenityList = roomAmenities
                    .stream()
                    .filter(a -> a.getRoomId().equals(room.getId()))
                    .map(RoomAmenitiesEntity::getAmenityId)
                    .collect(Collectors.toList());
            roomAmenitiesMap.put(room.getId(), amenities
                    .stream()
                    .filter(amenity -> amenityList.contains(amenity.getId()))
                    .collect(Collectors.toList()));
        });
        return roomsEntityMapper.mapToRoom(rooms, roomAmenitiesMap);
    }

}
