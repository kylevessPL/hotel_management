package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.AmenitiesEntity;

import java.util.List;

public interface AmenitiesEntityDao extends JpaRepository<AmenitiesEntity, Integer> {

    List<AmenitiesEntity> findAllByIdIn(List<Integer> id);

}
