package pl.piasta.hotel.dto.rooms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class RoomDto {

    private final int id;
    private final int bedAmount;
    private final BigDecimal standardPrice;

}
