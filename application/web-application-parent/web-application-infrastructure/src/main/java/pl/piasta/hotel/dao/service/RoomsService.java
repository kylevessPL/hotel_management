package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.RoomsEntity;

import java.math.BigDecimal;
import java.util.List;

public interface RoomsService {

	List<RoomsEntity> findAll();
	RoomsEntity findById(Integer id);

	@Query(value = "Select * from rooms where room_number = :room_number", nativeQuery = true)
    RoomsEntity findByRoomNumber(@Param("room_number") String roomNumber);

	@Query(value = "Select * from rooms where bed_amount = :bed_amount", nativeQuery = true)
	RoomsEntity findByBedAmount(@Param("bed_amount") Integer bedAmount);

	@Query(value = "Select * from rooms where standard_price = :standard_price", nativeQuery = true)
	RoomsEntity findByStandardPrice(@Param("standard_price") BigDecimal standardPrice);

	long count();
	void delete(RoomsEntity roomsEntity);
	void save(RoomsEntity roomsEntity);

}
