package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.BookingsServicesEntity;

import java.util.List;

public interface BookingsServicesService {

	List<BookingsServicesEntity> findAll();
	BookingsServicesEntity findById(Integer id);
	long count();
	void delete(BookingsServicesEntity bookingsServicesEntity);
	void save(BookingsServicesEntity bookingsServicesEntity);

}
