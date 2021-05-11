package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.dto.amenities.AmenityResponse;

import java.util.List;

@Mapper
public interface AmenityMapper {

    List<AmenityResponse> mapToResponse(List<Amenity> amenities);

}
