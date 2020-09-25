package pl.piasta.hotel.dto.amenities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class AmenityResponse {

    @ApiModelProperty(value = "Amenity name", example = "[\"en suite\", \"balcony\", \"TV\", \"radio\", \"phone\", \"A/C\"]")
    private String name;

}
