package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;

import java.math.BigDecimal;
import java.util.List;

public interface SpecialOffersService {

	List<SpecialOffersEntity> findAll();
	SpecialOffersEntity findById(Integer id);

	@Query(value = "Select * from special_offers where discount = :discount", nativeQuery = true)
	SpecialOffersEntity findByDiscount(@Param("discount") BigDecimal discount);

	@Query(value = "Select * from special_offers where bookings_amount = :bookings_amount", nativeQuery = true)
	SpecialOffersEntity findByBookingsAmount(@Param("bookings_amount") Integer bookingsAmount);

	@Query(value = "Select * from special_offers where description = :description", nativeQuery = true)
	SpecialOffersEntity findByDescription(@Param("description") String description);

	long count();
	void delete(SpecialOffersEntity specialOffersEntity);
	void save(SpecialOffersEntity specialOffersEntity);

}
