package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServicesEntity, Integer>, JpaSpecificationExecutor<AdditionalServicesEntity> {

    @Query(value = "Select * from additional_services where name = :name", nativeQuery = true)
    Optional<List<AdditionalServicesEntity>> findByName(@Param("name") String name);

}
