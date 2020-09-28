package pl.piasta.hotel.dto.rooms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityResponse;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class RoomResponse {

    @ApiModelProperty(value = "Room id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Room bed amount", example = "4")
    private Integer bedAmount;
    @ApiModelProperty(value = "Room amenities", example = "[\"en suite\", \"TV\", \"phone\", \"A/C\"]")
    private List<AmenityResponse> amenities;
    @ApiModelProperty(value = "Room price", example = "600.53")
    private BigDecimal standardPrice;

}
