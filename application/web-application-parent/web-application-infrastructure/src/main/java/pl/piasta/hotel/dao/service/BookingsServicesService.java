package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.BookingsServicesEntity;

import java.util.List;

public interface BookingsServicesService {

	List<BookingsServicesEntity> findAll();
	BookingsServicesEntity findById(Integer id);
	List<BookingsServicesEntity> findByServiceId(@Param("service_id") Integer serviceId);
	long count();
	void delete(BookingsServicesEntity bookingsServicesEntity);
	void save(BookingsServicesEntity bookingsServicesEntity);

}
