package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;

import java.math.BigDecimal;
import java.util.List;

public interface SpecialOffersService {

	List<SpecialOffersEntity> findAll();
	SpecialOffersEntity findById(Integer id);
	List<SpecialOffersEntity> findByDiscount(BigDecimal discount);
	List<SpecialOffersEntity> findByBookingsAmount(Integer bookingsAmount);
	List<SpecialOffersEntity> findByDescription(String description);
	long count();
	void delete(SpecialOffersEntity specialOffersEntity);
	void save(SpecialOffersEntity specialOffersEntity);

}
