package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;

import java.util.List;

public interface RoomAmenitiesService {

	List<RoomAmenitiesEntity> findAll();
	RoomAmenitiesEntity findById(Integer id);

	@Query(value = "Select * from room_amenities where amenity_id = :amenity_id", nativeQuery = true)
    RoomAmenitiesEntity findByAmenityId(@Param("amenity_id") Integer amenityId);

    long count();
	void delete(RoomAmenitiesEntity roomAmenitiesEntity);
	void save(RoomAmenitiesEntity roomAmenitiesEntity);

}
