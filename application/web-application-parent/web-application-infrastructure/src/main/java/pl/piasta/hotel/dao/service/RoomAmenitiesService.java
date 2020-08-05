package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;

import java.util.List;

public interface RoomAmenitiesService {

	List<RoomAmenitiesEntity> findAll();
	RoomAmenitiesEntity findById(Integer id);
	long count();
	void delete(RoomAmenitiesEntity roomAmenitiesEntity);
	void save(RoomAmenitiesEntity roomAmenitiesEntity);

}
