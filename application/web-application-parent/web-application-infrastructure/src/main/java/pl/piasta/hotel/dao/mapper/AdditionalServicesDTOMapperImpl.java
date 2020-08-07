package pl.piasta.hotel.dao.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.piasta.hotel.application.additionalservices.service.AdditionalServicesDTO;
import pl.piasta.hotel.application.additionalservices.service.AdditionalServicesDTOMapper;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;
import pl.piasta.hotel.dao.repository.AdditionalServicesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdditionalServicesDTOMapperImpl implements AdditionalServicesDTOMapper {

    private final AdditionalServicesRepository additionalServicesRepository;

    @Autowired
    AdditionalServicesDTOMapperImpl(AdditionalServicesRepository additionalServicesRepository) {
        this.additionalServicesRepository = additionalServicesRepository;
    }

    @Override
    public List<AdditionalServicesDTO> findAll() {
        return additionalServicesRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdditionalServicesDTO findById(Integer id) {
        return convertToDTO(additionalServicesRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<AdditionalServicesDTO> findByName(String name) {
        return additionalServicesRepository
                .findByName(name).orElseThrow(EntityNotFoundException::new)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AdditionalServicesDTO convertToDTO(AdditionalServicesEntity additionalServicesEntity) {
        AdditionalServicesDTO additionalServicesDTO = new AdditionalServicesDTO();
        additionalServicesDTO.setId(additionalServicesEntity.getId());
        additionalServicesDTO.setName(additionalServicesEntity.getName());
        additionalServicesDTO.setPrice(additionalServicesEntity.getPrice());
        return additionalServicesDTO;
    }

}
