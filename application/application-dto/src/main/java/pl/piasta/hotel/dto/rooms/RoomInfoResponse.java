package pl.piasta.hotel.dto.rooms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityResponse;

import java.util.List;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoResponse {

    @ApiModelProperty(value = "Room number", example = "P01")
    private String roomNumber;
    @ApiModelProperty(value = "Room bed amount", example = "4")
    private Integer bedAmount;
    @ApiModelProperty(value = "Room amenities", example = "[\"en suite\", \"TV\", \"phone\", \"A/C\"]")
    private List<AmenityResponse> amenities;

}
