package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.RoomDetails;
import pl.piasta.hotel.domain.model.rooms.utils.RoomFinalDetails;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.AmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomAmenitiesEntityDao;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.RoomsEntityMapper;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    @Transactional(readOnly = true)
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate) {
        List<Integer> bookedRooms = bookingsDao.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate)
                .stream()
                .map(BookingsEntity::getRoomId)
                .collect(Collectors.toList());
        List<RoomsEntity> rooms = bookedRooms.isEmpty() ? roomsDao.findAll() : roomsDao.findByIdNotIn(bookedRooms);
        List<RoomAmenitiesEntity> roomAmenities = roomAmenitiesDao.findAllByRoomIdIn(rooms
                .stream()
                .map(RoomsEntity::getId)
                .distinct()
                .collect(Collectors.toList()));
        List<AmenitiesEntity> amenities = amenitiesDao.findAllByIdIn(roomAmenities
                .stream()
                .map(RoomAmenitiesEntity::getAmenityId)
                .distinct()
                .collect(Collectors.toList()));

        Map<Integer, List<AmenitiesEntity>> roomAmenitiesMap = new HashMap<>();
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

    @Override
    @Transactional(readOnly = true)
    public Optional<RoomDetails> getRoomDetails(Integer roomId) {
        Optional<RoomsEntity> roomsEntity = roomsDao.findById(roomId);
        if(roomsEntity.isPresent()) {
            return roomsEntityMapper.mapToRoomDetails(roomsEntity);
        }
        return Optional.empty();
    }

    @Override
    public RoomFinalDetails getRoomFinalDetails(Integer roomId) {
        RoomsEntity room = roomsDao.getOne(roomId);
        List<RoomAmenitiesEntity> roomAmenities = roomAmenitiesDao.findAllByRoomId(room.getId());
        List<AmenitiesEntity> amenities = amenitiesDao.findAllByIdIn(roomAmenities
                .stream()
                .map(RoomAmenitiesEntity::getAmenityId)
                .distinct()
                .collect(Collectors.toList()));
        return roomsEntityMapper.mapToRoomFinalDetails(room, amenities);
    }

}
