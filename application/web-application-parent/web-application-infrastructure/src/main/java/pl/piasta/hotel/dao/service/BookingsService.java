package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.BookingsEntity;

import java.util.List;

public interface BookingsService {

	List<BookingsEntity> findAll();
	BookingsEntity findById(Integer id);
	long count();
	void delete(BookingsEntity bookingsEntity);
	void save(BookingsEntity bookingsEntity);

}
