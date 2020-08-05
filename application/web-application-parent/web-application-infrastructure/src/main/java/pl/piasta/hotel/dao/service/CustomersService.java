package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.CustomersEntity;

import java.util.List;

public interface CustomersService {

	List<CustomersEntity> findAll();
	CustomersEntity findById(Integer id);
	List<CustomersEntity> findByFirstName(String firstName);
	List<CustomersEntity> findByLastName(String lastName);
	List<CustomersEntity> findByFirstAndLastName(String firstName, String lastName);
	List<CustomersEntity> findByStreetName(String streetName);
	List<CustomersEntity> findByHouseNumber(Integer houseNumber);
	List<CustomersEntity> findByZipCode(String zipCode);
	List<CustomersEntity> findByCity(String city);
	List<CustomersEntity> findByDocumentType(String documentType);
	List<CustomersEntity> findByDocumentId(String documentId);
	long count();
	void delete(CustomersEntity customersEntity);
	void save(CustomersEntity customersEntity);

}
