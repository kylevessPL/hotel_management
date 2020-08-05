package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.BookingsEntity;
import pl.piasta.hotel.dao.repository.BookingsRepository;
import pl.piasta.hotel.dao.service.BookingsService;

import javax.persistence.EntityNotFoundException;
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
