package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomAmenitiesRepository extends JpaRepository<RoomAmenitiesEntity, Integer>, JpaSpecificationExecutor<RoomAmenitiesEntity> {

    @Query(value = "Select * from room_amenities where amenity_id = :amenity_id", nativeQuery = true)
    Optional<List<RoomAmenitiesEntity>> findByAmenityId(@Param("amenity_id") Integer amenityId);

}
