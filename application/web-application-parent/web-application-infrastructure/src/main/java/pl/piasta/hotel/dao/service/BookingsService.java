package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookingsService {

	List<BookingsEntity> findAll();
	BookingsEntity findById(Integer id);

	@Query(value = "Select * from bookings where book_date = :book_date", nativeQuery = true)
    BookingsEntity findByBookDate(@Param("book_date") Date bookDate);

	@Query(value = "Select * from bookings where end_date = :end_date", nativeQuery = true)
	BookingsEntity findByEndDate(@Param("end_date") Date endDate);

	@Query(value = "Select * from bookings where customer_id = :customer_id", nativeQuery = true)
	BookingsEntity findByCustomerId(@Param("customer_id") Integer customerId);

	@Query(value = "Select * from bookings where room_id = :room_id", nativeQuery = true)
	BookingsEntity findByRoomId(@Param("room_id") Integer roomId);

	@Query(value = "Select * from bookings where offer_id = :offer_id", nativeQuery = true)
	BookingsEntity findByOfferId(@Param("offer_id") Integer offerId);

	@Query(value = "Select * from bookings where final_price = :final_price", nativeQuery = true)
	BookingsEntity findByFinalPrice(@Param("final_price") BigDecimal finalPrice);

	@Query(value = "Select * from bookings where payment_id = :payment_id", nativeQuery = true)
	BookingsEntity findByPaymentId(@Param("payment_id") Integer paymentId);

	long count();
	void delete(BookingsEntity bookingsEntity);
	void save(BookingsEntity bookingsEntity);

}
