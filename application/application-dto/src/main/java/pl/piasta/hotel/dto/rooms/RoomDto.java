package pl.piasta.hotel.dto.rooms;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityDto;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "bed-amount", "standard-price", "amenities" })
public class RoomDto {

    private int id;
    private int bedAmount;
    private BigDecimal standardPrice;
    private List<AmenityDto> amenities;

}
