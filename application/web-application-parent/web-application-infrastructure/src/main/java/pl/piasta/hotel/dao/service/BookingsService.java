package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookingsService {

	List<BookingsEntity> findAll();
	BookingsEntity findById(Integer id);
	List<BookingsEntity> findByBookDate(Date bookDate);
	List<BookingsEntity> findByEndDate(Date endDate);
	List<BookingsEntity> findByCustomerId(Integer customerId);
	List<BookingsEntity> findByRoomId(Integer roomId);
	List<BookingsEntity> findByOfferId(Integer offerId);
	List<BookingsEntity> findByFinalPrice(BigDecimal finalPrice);
	List<BookingsEntity> findByPaymentId(Integer paymentId);
	long count();
	void delete(BookingsEntity bookingsEntity);
	void save(BookingsEntity bookingsEntity);

}
