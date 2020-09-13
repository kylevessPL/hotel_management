package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdditionalServicesEntityMapper {

    public List<AdditionalService> mapToAdditionalService(List<AdditionalServicesEntity> additionalServices) {
        return additionalServices.stream()
                .map(entity -> new AdditionalService(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

    public Optional<List<AdditionalService>> mapToAdditionalServiceOptional(List<AdditionalServicesEntity> additionalServices) {
        return Optional.of(additionalServices.stream()
                .map(entity -> new AdditionalService(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList()));
    }

}
