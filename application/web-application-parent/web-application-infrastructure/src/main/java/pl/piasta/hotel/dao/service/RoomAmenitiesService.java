package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;

import java.util.List;

public interface RoomAmenitiesService {

	List<RoomAmenitiesEntity> findAll();
	RoomAmenitiesEntity findById(Integer id);
	List<RoomAmenitiesEntity> findByAmenityId(Integer amenityId);
    long count();
	void delete(RoomAmenitiesEntity roomAmenitiesEntity);
	void save(RoomAmenitiesEntity roomAmenitiesEntity);

}
