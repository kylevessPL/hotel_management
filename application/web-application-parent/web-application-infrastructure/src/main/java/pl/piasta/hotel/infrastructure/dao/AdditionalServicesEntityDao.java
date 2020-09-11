package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;

import java.util.List;

public interface AdditionalServicesEntityDao extends JpaRepository<AdditionalServicesEntity, Integer> {

    List<AdditionalServicesEntity> findAllByIdIn(List<Integer> additionalServices);

}
