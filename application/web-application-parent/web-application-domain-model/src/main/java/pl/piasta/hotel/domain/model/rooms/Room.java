package pl.piasta.hotel.domain.model.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.amenities.Amenity;

import java.math.BigDecimal;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
public class Room {

    private final int id;
    private final int bedAmount;
    private final BigDecimal standardPrice;
    private final Set<Amenity> amenities;

}
