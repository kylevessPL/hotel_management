package pl.piasta.hotel.api.additionalservices.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;

import java.util.List;

@Mapper
public interface AdditionalServiceMapper {

    List<AdditionalServiceResponse> mapToResponse(List<AdditionalService> additionalServices);

}
