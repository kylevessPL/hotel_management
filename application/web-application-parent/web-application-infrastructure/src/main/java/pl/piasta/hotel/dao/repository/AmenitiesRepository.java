package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.AmenitiesEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface AmenitiesRepository extends JpaRepository<AmenitiesEntity, Integer>, JpaSpecificationExecutor<AmenitiesEntity> {

    @Query(value = "Select * from amenities where name = :name", nativeQuery = true)
    Optional<List<AmenitiesEntity>> findByName(@Param("name") String name);

}
