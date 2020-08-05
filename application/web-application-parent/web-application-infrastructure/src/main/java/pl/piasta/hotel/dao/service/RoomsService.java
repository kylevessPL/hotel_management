package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.RoomsEntity;

import java.math.BigDecimal;
import java.util.List;

public interface RoomsService {

	List<RoomsEntity> findAll();
	RoomsEntity findById(Integer id);
	List<RoomsEntity> findByRoomNumber(String roomNumber);
	List<RoomsEntity> findByBedAmount(Integer bedAmount);
	List<RoomsEntity> findByStandardPrice(BigDecimal standardPrice);
	long count();
	void delete(RoomsEntity roomsEntity);
	void save(RoomsEntity roomsEntity);

}
