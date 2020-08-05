package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.CustomersEntity;

import java.util.List;

public interface CustomersService {

	List<CustomersEntity> findAll();
	CustomersEntity findById(Integer id);
	long count();
	void delete(CustomersEntity customersEntity);
	void save(CustomersEntity customersEntity);

}
