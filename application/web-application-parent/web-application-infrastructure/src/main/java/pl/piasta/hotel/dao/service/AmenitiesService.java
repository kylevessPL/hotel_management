package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.AmenitiesEntity;

import java.util.List;

public interface AmenitiesService {

	List<AmenitiesEntity> findAll();
	AmenitiesEntity findById(Integer id);
	long count();
	void delete(AmenitiesEntity amenitiesEntity);
	void save(AmenitiesEntity amenitiesEntity);

}
