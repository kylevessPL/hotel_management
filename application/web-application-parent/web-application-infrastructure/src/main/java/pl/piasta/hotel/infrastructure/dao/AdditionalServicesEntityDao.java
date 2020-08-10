package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;

import java.util.List;
import java.util.Optional;

public interface AdditionalServicesEntityDao extends JpaRepository<AdditionalServicesEntity, Integer> {

    @Query(value = "Select * from additional_services where name = :name", nativeQuery = true)
    Optional<List<AdditionalServicesEntity>> findByName(@Param("name") String name);

}
