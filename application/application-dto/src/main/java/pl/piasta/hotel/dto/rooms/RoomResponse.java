package pl.piasta.hotel.dto.rooms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityResponse;

import java.math.BigDecimal;
import java.util.List;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class RoomResponse {

    @Schema(description = "Room id", example = "1")
    private Integer id;
    @Schema(description = "Room bed amount", example = "4")
    private Integer bedAmount;
    @Schema(description = "Room amenities")
    private List<AmenityResponse> amenities;
    @Schema(description = "Room price", example = "600.53")
    private BigDecimal standardPrice;
}
