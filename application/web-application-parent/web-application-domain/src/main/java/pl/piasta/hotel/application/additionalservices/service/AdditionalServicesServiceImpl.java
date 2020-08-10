package pl.piasta.hotel.application.additionalservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.additionalservices.AdditionalService;

import java.util.List;

@Service
public class AdditionalServicesServiceImpl implements AdditionalServicesService {

    private final AdditionalServicesRepository repository;

    @Autowired
    public AdditionalServicesServiceImpl(AdditionalServicesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return repository.getAllAdditionalServices();
    }
}
