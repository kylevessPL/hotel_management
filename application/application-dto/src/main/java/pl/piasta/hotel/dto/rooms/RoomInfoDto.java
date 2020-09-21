package pl.piasta.hotel.dto.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.amenities.AmenityDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomInfoDto {

    private String roomNumber;
    private Integer bedAmount;
    private List<AmenityDto> amenities;

}
