package pl.piasta.hotel.dto.rooms;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "bed-amount")
    private int bedAmount;
    @JsonProperty(value = "standard-price")
    private BigDecimal standardPrice;
    private List<AmenityDto> amenities;

}
