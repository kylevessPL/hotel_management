package pl.piasta.hotel.domain.model.rooms.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class RoomDetails {

    private final Integer roomId;
    private final BigDecimal standardPrice;

}
