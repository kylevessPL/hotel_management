package pl.piasta.hotel.infrastructure.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoomsEntityMapper {

    private final AmenitiesEntityMapper amenitiesEntityMapper;

    public Room mapToRoom(RoomsEntity room, List<AmenitiesEntity> amenities) {
        return new Room(
                        room.getId(),
                        room.getBedAmount(),
                        room.getStandardPrice(),
                        amenitiesEntityMapper.mapToAmenity(amenities));
    }

}
