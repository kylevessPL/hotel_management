package pl.piasta.hotel.domainmodel.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domainmodel.amenities.Amenity;

import java.util.List;

@RequiredArgsConstructor
@Getter
public final class RoomFinalDetails {

    private final String roomNumber;
    private final Integer bedAmount;
    private final List<Amenity> amenities;

}
