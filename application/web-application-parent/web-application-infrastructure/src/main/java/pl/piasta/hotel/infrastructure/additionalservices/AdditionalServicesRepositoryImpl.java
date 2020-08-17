package pl.piasta.hotel.infrastructure.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.additionalservices.mapper.AdditionalServicesEntityMapper;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdditionalServicesRepositoryImpl implements AdditionalServicesRepository {

    private final AdditionalServicesEntityMapper additionalServicesEntityMapper;
    private final AdditionalServicesEntityDao dao;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return additionalServicesEntityMapper.mapToAdditionalService(dao.findAll());
    }

}
