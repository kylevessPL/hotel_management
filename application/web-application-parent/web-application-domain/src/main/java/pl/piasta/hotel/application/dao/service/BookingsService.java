package pl.piasta.hotel.application.dao.service;

import pl.piasta.hotel.dao.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface BookingsService {

	List<BookingsEntity> findAll();
	BookingsEntity findById(Integer id);
	List<BookingsEntity> findByBookDate(Date bookDate);
	List<BookingsEntity> findByStartDate(Date startDate);
	List<BookingsEntity> findByEndDate(Date endDate);
	List<BookingsEntity> findByCustomerId(Integer customerId);
	List<BookingsEntity> findByRoomId(Integer roomId);
	List<BookingsEntity> findByOfferId(Integer offerId);
	List<BookingsEntity> findByFinalPrice(BigDecimal finalPrice);
	long count();
	void delete(BookingsEntity bookingsEntity);
	void save(BookingsEntity bookingsEntity);

}
