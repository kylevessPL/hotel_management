package pl.piasta.hotel.domain.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdditionalServicesServiceImpl implements AdditionalServicesService {

    private final AdditionalServicesRepository repository;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return repository.getAllAdditionalServices();
    }

    @Override
    public AdditionalService getAdditionalServiceById(int id) {
        return repository.getAdditionalServiceById(id);
    }

    @Override
    public List<AdditionalService> getAdditionalServicesByName(String name) {
        return repository.getAdditionalServicesByName(name);
    }


}
