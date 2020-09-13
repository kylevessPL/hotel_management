package pl.piasta.hotel.infrastructure.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;
import pl.piasta.hotel.infrastructure.mapper.AdditionalServicesEntityMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdditionalServicesRepositoryImpl implements AdditionalServicesRepository {

    private final AdditionalServicesEntityMapper additionalServicesMapper;
    private final AdditionalServicesEntityDao dao;

    @Override
    public List<AdditionalService> getAllAdditionalServices() {
        return additionalServicesMapper.mapToAdditionalService(dao.findAll());
    }

    @Override
    public Optional<List<AdditionalService>> getAllAdditionalServicesById(List<Integer> additionalServicesList) {
        return additionalServicesMapper.mapToAdditionalServiceOptional(dao.findAllByIdIn(additionalServicesList));
    }

}
