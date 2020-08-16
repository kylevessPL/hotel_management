package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.dto.amenities.AmenityDto;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AmenityMapper {

    Set<AmenityDto> mapToDto(Set<Amenity> amenities);

}
