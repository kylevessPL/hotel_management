package pl.piasta.hotel.domain.model.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domain.model.amenities.Amenity;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
public final class Room {

    private final Integer id;
    private final Integer bedAmount;
    private final BigDecimal standardPrice;
    private final List<Amenity> amenities;

}
