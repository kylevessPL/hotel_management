package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;

import java.math.BigDecimal;
import java.util.List;

public interface SpecialOffersService {

	List<SpecialOffersEntity> findAll();
	SpecialOffersEntity findById(Integer id);
	List<SpecialOffersEntity> findByDiscount(@Param("discount") BigDecimal discount);
	List<SpecialOffersEntity> findByBookingsAmount(@Param("bookings_amount") Integer bookingsAmount);
	List<SpecialOffersEntity> findByDescription(@Param("description") String description);
	long count();
	void delete(SpecialOffersEntity specialOffersEntity);
	void save(SpecialOffersEntity specialOffersEntity);

}
