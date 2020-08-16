package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.dto.amenities.AmenityDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AmenityMapper {

    List<AmenityDto> mapToDto(List<Amenity> amenities);

}
