package pl.piasta.hotel.infrastructure.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AdditionalServicesRepositoryImpl implements AdditionalServicesRepository {

    private final AdditionalServicesEntityDao dao;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return dao.findAll().stream()
                .map(entity -> new AdditionalService(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

}
