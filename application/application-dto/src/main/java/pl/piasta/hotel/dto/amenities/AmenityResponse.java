package pl.piasta.hotel.dto.amenities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class AmenityResponse {

    @Schema(description = "Amenity name", example = "TV")
    private String name;
}
