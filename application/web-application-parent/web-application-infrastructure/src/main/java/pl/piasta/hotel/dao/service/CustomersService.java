package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.CustomersEntity;

import java.util.List;

public interface CustomersService {

	List<CustomersEntity> findAll();
	CustomersEntity findById(Integer id);
	List<CustomersEntity> findByFirstName(@Param("first_name") String firstName);
	List<CustomersEntity> findByLastName(@Param("last_name") String lastName);
	List<CustomersEntity> findByStreetName(@Param("street_name") String streetName);
	List<CustomersEntity> findByHouseNumber(@Param("house_number") Integer houseNumber);
	List<CustomersEntity> findByZipCode(@Param("zip_code") String zipCode);
	List<CustomersEntity> findByCity(@Param("city") String city);
	List<CustomersEntity> findByDocumentType(@Param("document_type") String documentType);
	List<CustomersEntity> findByDocumentId(@Param("document_id") String documentId);
	long count();
	void delete(CustomersEntity customersEntity);
	void save(CustomersEntity customersEntity);

}
