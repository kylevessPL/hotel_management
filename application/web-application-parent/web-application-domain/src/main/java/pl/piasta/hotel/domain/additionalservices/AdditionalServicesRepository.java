package pl.piasta.hotel.domain.additionalservices;

import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;

import java.util.List;

public interface AdditionalServicesRepository {

    List<AdditionalService> getAllAdditionalServices();

}
