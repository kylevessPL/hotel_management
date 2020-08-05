package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.CustomersEntity;

import java.util.List;

public interface CustomersService {

	List<CustomersEntity> findAll();
	CustomersEntity findById(Integer id);

	@Query(value = "Select * from customers where first_name = :first_name", nativeQuery = true)
	CustomersEntity findByFirstName(@Param("first_name") String firstName);

	@Query(value = "Select * from customers where last_name = :last_name", nativeQuery = true)
	CustomersEntity findByLastName(@Param("last_name") String lastName);

	@Query(value = "Select * from customers where street_name = :street_name", nativeQuery = true)
	CustomersEntity findByStreetName(@Param("street_name") String streetName);

	@Query(value = "Select * from customers where house_number = :house_number", nativeQuery = true)
	CustomersEntity findByHouseNumber(@Param("house_number") Integer houseNumber);

	@Query(value = "Select * from customers where zip_code = :zip_code", nativeQuery = true)
	CustomersEntity findByZipCodeString(@Param("zip_code") String zipCode);

	@Query(value = "Select * from customers where city = :city", nativeQuery = true)
	CustomersEntity findByCity(@Param("city") String city);

	@Query(value = "Select * from customers where document_type = :document_type", nativeQuery = true)
	CustomersEntity findByDocumentType(@Param("document_type") String documentType);

	@Query(value = "Select * from customers where document_id = :document_id", nativeQuery = true)
	CustomersEntity findByDocumentId(@Param("document_id") String documentId);

	long count();
	void delete(CustomersEntity customersEntity);
	void save(CustomersEntity customersEntity);

}
