package pl.piasta.hotel.dto.rooms;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class RoomDto {

    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "bed-amount")
    private int bedAmount;
    @JsonProperty(value = "standard-price")
    private BigDecimal standardPrice;
    @JsonProperty(value = "amenities")
    private List<AmenityDto> amenities;

}
