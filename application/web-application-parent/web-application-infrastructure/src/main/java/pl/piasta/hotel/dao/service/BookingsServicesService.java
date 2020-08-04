package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.BookingsServicesEntity;
import pl.piasta.hotel.dao.repository.BookingsServicesRepository;

import java.util.List;

@Service
public class BookingsServicesService {

	private final BookingsServicesRepository bookingsServicesRepository;

	@Autowired
	public BookingsServicesService(BookingsServicesRepository bookingsServicesRepository) {
		this.bookingsServicesRepository = bookingsServicesRepository;
	}

	public List<BookingsServicesEntity> findAll() {
		return bookingsServicesRepository.findAll();
	}

	public long count() {
		return bookingsServicesRepository.count();
	}

	public void delete(BookingsServicesEntity bookingsServicesEntity) {
		bookingsServicesRepository.delete(bookingsServicesEntity);
	}

	public void save(BookingsServicesEntity bookingsServicesEntity) {
		if (bookingsServicesEntity == null) {
			return;
		}
		bookingsServicesRepository.save(bookingsServicesEntity);
	}

}
