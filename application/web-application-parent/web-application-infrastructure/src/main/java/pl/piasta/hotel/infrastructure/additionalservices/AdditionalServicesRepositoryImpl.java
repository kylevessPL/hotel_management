package pl.piasta.hotel.infrastructure.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;
import pl.piasta.hotel.infrastructure.mapper.AdditionalServicesEntityMapper;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AdditionalServicesRepositoryImpl implements AdditionalServicesRepository {

    private final AdditionalServicesEntityMapper additionalServicesMapper;
    private final AdditionalServicesEntityDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<AdditionalService> getAllAdditionalServices() {
        return additionalServicesMapper.mapToAdditionalService(dao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<AdditionalService>> getAllAdditionalServices(List<Integer> additionalServicesList) {
        List<AdditionalService> additionalServices = null;
        List<AdditionalServicesEntity> additionalServicesEntities = dao.findAllByIdIn(additionalServicesList);
        if(containsAllFromList(additionalServicesEntities, additionalServicesList)) {
            additionalServices = additionalServicesMapper.mapToAdditionalService(additionalServicesEntities);
        }
        return Optional.ofNullable(additionalServices);
    }

    boolean containsAllFromList(List<AdditionalServicesEntity> additionalServicesEntities, List<Integer> additionalServicesList) {
        return additionalServicesEntities
                .stream()
                .map(AdditionalServicesEntity::getId)
                .collect(Collectors.toList())
                .containsAll(additionalServicesList);
    }

}
