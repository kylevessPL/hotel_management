package pl.piasta.hotel.infrastructure.additionalservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.application.additionalservices.service.AdditionalServicesRepository;
import pl.piasta.hotel.domain.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AdditionalServicesRepositoryImpl implements AdditionalServicesRepository {

    private final AdditionalServicesEntityDao dao;

    @Autowired
    public AdditionalServicesRepositoryImpl(AdditionalServicesEntityDao dao) {
        this.dao = dao;
    }

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return dao.findAll().stream()
                .map(entity -> new AdditionalService(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }
}
