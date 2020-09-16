package pl.piasta.hotel.infrastructure.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.RoomDetails;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomsEntityMapper {

    private final AmenitiesEntityMapper amenitiesEntityMapper;

     public List<Room> mapToRoom(List<RoomsEntity> rooms, Map<Integer, List<AmenitiesEntity>> roomAmenitiesMap) {
        return rooms.stream()
                .map(entity -> new Room(
                        entity.getId(),
                        entity.getBedAmount(),
                        entity.getStandardPrice(),
                        amenitiesEntityMapper.mapToAmenity(roomAmenitiesMap.get(entity.getId()))))
                .collect(Collectors.toList());
    }

    public RoomDetails mapToRoomDetails(RoomsEntity rooms) {
         return new RoomDetails(
                 rooms.getId(),
                 rooms.getStandardPrice()
         );
    }

}
