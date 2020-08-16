package pl.piasta.hotel.api.additionalservices.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdditionalServiceMapper {

    List<AdditionalServiceDto> mapToDto(List<AdditionalService> additionalServices);

}
