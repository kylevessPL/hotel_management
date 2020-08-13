package pl.piasta.hotel.dto.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class RoomDto {

    private int id;
    private int bedAmount;
    private BigDecimal standardPrice;

}
