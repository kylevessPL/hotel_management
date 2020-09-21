package pl.piasta.hotel.domain.model.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.amenities.Amenity;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class RoomInfo {

    private final String roomNumber;
    private final Integer bedAmount;
    private final List<Amenity> amenities;

}
