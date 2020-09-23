package pl.piasta.hotel.domain.model.rooms.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public final class RoomDetails {

    private final Integer roomId;
    private final BigDecimal standardPrice;

}
