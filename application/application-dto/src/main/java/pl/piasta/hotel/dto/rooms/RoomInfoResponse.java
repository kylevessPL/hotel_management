package pl.piasta.hotel.dto.rooms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityResponse;

import java.util.List;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoResponse {

    @Schema(description = "Room number", example = "P01")
    private String roomNumber;
    @Schema(description = "Room bed amount", example = "4")
    private Integer bedAmount;
    @Schema(description = "Room amenities")
    private List<AmenityResponse> amenities;
}
