package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.RoomsEntity;

import java.util.List;

public interface RoomsService {

	List<RoomsEntity> findAll();
	RoomsEntity findById(Integer id);
	long count();
	void delete(RoomsEntity roomsEntity);
	void save(RoomsEntity roomsEntity);

}
