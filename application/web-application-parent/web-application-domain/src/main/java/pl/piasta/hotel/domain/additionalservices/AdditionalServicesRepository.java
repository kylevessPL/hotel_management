package pl.piasta.hotel.domain.additionalservices;

import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;

import java.util.List;
import java.util.Optional;

public interface AdditionalServicesRepository {

    List<AdditionalService> getAdditionalServices();
    Optional<List<AdditionalService>> getAdditionalServices(List<Integer> additionalServicesList);

}
