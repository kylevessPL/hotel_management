package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AmenitiesEntityMapper {

    public List<Amenity> mapToAmenity(List<AmenitiesEntity> amenities) {
        return amenities.stream()
                .map(amenity -> new Amenity(amenity.getName()))
                .collect(Collectors.toList());
    }

}
