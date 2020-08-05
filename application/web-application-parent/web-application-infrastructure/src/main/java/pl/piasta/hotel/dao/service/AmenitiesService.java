package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.AmenitiesEntity;

import java.util.List;

public interface AmenitiesService {

	List<AmenitiesEntity> findAll();
	AmenitiesEntity findById(Integer id);
    List<AmenitiesEntity> findByName(String name);
    long count();
	void delete(AmenitiesEntity amenitiesEntity);
	void save(AmenitiesEntity amenitiesEntity);

}
