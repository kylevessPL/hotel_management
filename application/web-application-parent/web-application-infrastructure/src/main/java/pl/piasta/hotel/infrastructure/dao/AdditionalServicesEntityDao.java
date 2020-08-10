package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;

public interface AdditionalServicesEntityDao extends JpaRepository<AdditionalServicesEntity, Integer> {
}
