package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookingsService {

	List<BookingsEntity> findAll();
	BookingsEntity findById(Integer id);
	List<BookingsEntity> findByBookDate(@Param("book_date") Date bookDate);
	List<BookingsEntity> findByEndDate(@Param("end_date") Date endDate);
	List<BookingsEntity> findByCustomerId(@Param("customer_id") Integer customerId);
	List<BookingsEntity> findByRoomId(@Param("room_id") Integer roomId);
	List<BookingsEntity> findByOfferId(@Param("offer_id") Integer offerId);
	List<BookingsEntity> findByFinalPrice(@Param("final_price") BigDecimal finalPrice);
	List<BookingsEntity> findByPaymentId(@Param("payment_id") Integer paymentId);
	long count();
	void delete(BookingsEntity bookingsEntity);
	void save(BookingsEntity bookingsEntity);

}
