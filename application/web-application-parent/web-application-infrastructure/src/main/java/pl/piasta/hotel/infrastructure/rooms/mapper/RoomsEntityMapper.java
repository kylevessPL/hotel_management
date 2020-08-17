package pl.piasta.hotel.infrastructure.rooms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.infrastructure.amenities.mapper.AmenitiesEntityMapper;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomsEntityMapper {

    private final AmenitiesEntityMapper amenitiesEntityMapper;

     public List<Room> mapToRoom(List<RoomsEntity> rooms) {
        return rooms.stream()
                .map(entity -> new Room(
                        entity.getId(),
                        entity.getBedAmount(),
                        entity.getStandardPrice(),
                        amenitiesEntityMapper.mapToAmenity(entity.getAmenitiesEntities())))
                .collect(Collectors.toList());
    }

}
