package pl.piasta.hotel.application.dao.service;

import pl.piasta.hotel.dao.model.BookingsServicesEntity;

import java.util.List;

public interface BookingsServicesService {

	List<BookingsServicesEntity> findAll();
	BookingsServicesEntity findById(Integer id);
	List<BookingsServicesEntity> findByServiceId(Integer serviceId);
	long count();
	void delete(BookingsServicesEntity bookingsServicesEntity);
	void save(BookingsServicesEntity bookingsServicesEntity);

}
