package pl.piasta.hotel.domain.additionalservices;

import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;

import java.util.List;

public interface AdditionalServicesService {

    List<AdditionalService> getAllAdditionalServices();
    AdditionalService getAdditionalServiceById(int id);
    List<AdditionalService> getAdditionalServicesByName(String name);

}
