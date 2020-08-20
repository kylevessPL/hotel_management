package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;

public interface AmenitiesEntityDao extends JpaRepository<AmenitiesEntity, Integer> {
}
