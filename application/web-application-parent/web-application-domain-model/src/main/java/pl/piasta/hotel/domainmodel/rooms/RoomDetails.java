package pl.piasta.hotel.domainmodel.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public final class RoomDetails {

    private final Integer roomId;
    private final BigDecimal standardPrice;

}
