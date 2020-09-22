package pl.piasta.hotel.dto.rooms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityDto;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RoomDto {

    private Integer id;
    private Integer bedAmount;
    private List<AmenityDto> amenities;
    private BigDecimal standardPrice;

}
