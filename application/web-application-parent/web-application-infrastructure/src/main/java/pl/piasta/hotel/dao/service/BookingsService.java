package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.BookingsEntity;
import pl.piasta.hotel.dao.repository.BookingsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookingsService {

	private final BookingsRepository bookingsRepository;

	@Autowired
	public BookingsService(BookingsRepository bookingsRepository) {
		this.bookingsRepository = bookingsRepository;
	}

	public List<BookingsEntity> findAll() {
		return bookingsRepository.findAll();
	}

	public BookingsEntity findById(Integer id) {
		return bookingsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public long count() {
		return bookingsRepository.count();
	}

	public void delete(BookingsEntity bookingsEntity) {
		bookingsRepository.delete(bookingsEntity);
	}

	public void save(BookingsEntity bookingsEntity) {
		if (bookingsEntity == null) {
			return;
		}
		bookingsRepository.save(bookingsEntity);
	}

}
