package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.AmenitiesEntity;

import java.util.List;

public interface AmenitiesService {

	List<AmenitiesEntity> findAll();
	AmenitiesEntity findById(Integer id);

	@Query(value = "Select * from amenities where name = :name", nativeQuery = true)
    AmenitiesEntity findByName(@Param("name") String name);

    long count();
	void delete(AmenitiesEntity amenitiesEntity);
	void save(AmenitiesEntity amenitiesEntity);

}
