package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.BookingsEntity;
import pl.piasta.hotel.dao.repository.BookingsRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class BookingsServiceImpl implements BookingsService {

	private final BookingsRepository bookingsRepository;

	@Autowired
	public BookingsServiceImpl(BookingsRepository bookingsRepository) {
		this.bookingsRepository = bookingsRepository;
	}

	@Override
	public List<BookingsEntity> findAll() {
		return bookingsRepository.findAll();
	}

	@Override
	public BookingsEntity findById(Integer id) {
		return bookingsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByBookDate(Date bookDate) {
		return bookingsRepository.findByBookDate(bookDate).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByStartDate(Date startDate) {
		return bookingsRepository.findByStartDate(startDate).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByEndDate(Date endDate) {
		return bookingsRepository.findByEndDate(endDate).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByCustomerId(Integer customerId) {
		return bookingsRepository.findByCustomerId(customerId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByRoomId(Integer roomId) {
		return bookingsRepository.findByRoomId(roomId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByOfferId(Integer offerId) {
		return bookingsRepository.findByOfferId(offerId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsEntity> findByFinalPrice(BigDecimal finalPrice) {
		return bookingsRepository.findByFinalPrice(finalPrice).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return bookingsRepository.count();
	}

	@Override
	public void delete(BookingsEntity bookingsEntity) {
		bookingsRepository.delete(bookingsEntity);
	}

	@Override
	public void save(BookingsEntity bookingsEntity) {
		if (bookingsEntity == null) {
			return;
		}
		bookingsRepository.save(bookingsEntity);
	}

}
