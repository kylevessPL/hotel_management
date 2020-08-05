package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.RoomsEntity;

import java.math.BigDecimal;
import java.util.List;

public interface RoomsService {

	List<RoomsEntity> findAll();
	RoomsEntity findById(Integer id);
	List<RoomsEntity> findByRoomNumber(@Param("room_number") String roomNumber);
	List<RoomsEntity> findByBedAmount(@Param("bed_amount") Integer bedAmount);
	List<RoomsEntity> findByStandardPrice(@Param("standard_price") BigDecimal standardPrice);
	long count();
	void delete(RoomsEntity roomsEntity);
	void save(RoomsEntity roomsEntity);

}
