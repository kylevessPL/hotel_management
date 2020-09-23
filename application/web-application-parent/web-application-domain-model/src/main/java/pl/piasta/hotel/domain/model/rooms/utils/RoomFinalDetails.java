package pl.piasta.hotel.domain.model.rooms.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domain.model.amenities.Amenity;

import java.util.List;

@RequiredArgsConstructor
@Getter
public final class RoomFinalDetails {

    private final String roomNumber;
    private final Integer bedAmount;
    private final List<Amenity> amenities;

}
