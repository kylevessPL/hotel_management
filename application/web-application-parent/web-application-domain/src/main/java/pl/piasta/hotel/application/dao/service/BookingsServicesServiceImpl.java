package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.BookingsServicesEntity;
import pl.piasta.hotel.dao.repository.BookingsServicesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookingsServicesServiceImpl implements BookingsServicesService {

	private final BookingsServicesRepository bookingsServicesRepository;

	@Autowired
	public BookingsServicesServiceImpl(BookingsServicesRepository bookingsServicesRepository) {
		this.bookingsServicesRepository = bookingsServicesRepository;
	}

	@Override
	public List<BookingsServicesEntity> findAll() {
		return bookingsServicesRepository.findAll();
	}

	@Override
	public BookingsServicesEntity findById(Integer id) {
		return bookingsServicesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<BookingsServicesEntity> findByServiceId(Integer serviceId) {
		return bookingsServicesRepository.findByServiceId(serviceId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return bookingsServicesRepository.count();
	}

	@Override
	public void delete(BookingsServicesEntity bookingsServicesEntity) {
		bookingsServicesRepository.delete(bookingsServicesEntity);
	}

	@Override
	public void save(BookingsServicesEntity bookingsServicesEntity) {
		if (bookingsServicesEntity == null) {
			return;
		}
		bookingsServicesRepository.save(bookingsServicesEntity);
	}

}
