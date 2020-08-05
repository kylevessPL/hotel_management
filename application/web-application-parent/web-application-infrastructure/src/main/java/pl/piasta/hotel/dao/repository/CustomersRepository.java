package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.CustomersEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>, JpaSpecificationExecutor<CustomersEntity> {

    @Query(value = "Select * from customers where first_name = :first_name", nativeQuery = true)
    Optional<List<CustomersEntity>> findByFirstName(@Param("first_name") String firstName);

    @Query(value = "Select * from customers where last_name = :last_name", nativeQuery = true)
    Optional<List<CustomersEntity>> findByLastName(@Param("last_name") String lastName);

    @Query(value = "Select * from customers where first_name = :first_name and last_name = :last_name", nativeQuery = true)
    Optional<List<CustomersEntity>> findByFirstAndLastName(@Param("first_name") String firstName, @Param("last_name") String lastName);

    @Query(value = "Select * from customers where street_name = :street_name", nativeQuery = true)
    Optional<List<CustomersEntity>> findByStreetName(@Param("street_name") String streetName);

    @Query(value = "Select * from customers where house_number = :house_number", nativeQuery = true)
    Optional<List<CustomersEntity>> findByHouseNumber(@Param("house_number") Integer houseNumber);

    @Query(value = "Select * from customers where zip_code = :zip_code", nativeQuery = true)
    Optional<List<CustomersEntity>> findByZipCode(@Param("zip_code") String zipCode);

    @Query(value = "Select * from customers where city = :city", nativeQuery = true)
    Optional<List<CustomersEntity>> findByCity(@Param("city") String city);

    @Query(value = "Select * from customers where document_type = :document_type", nativeQuery = true)
    Optional<List<CustomersEntity>> findByDocumentType(@Param("document_type") String documentType);

    @Query(value = "Select * from customers where document_id = :document_id", nativeQuery = true)
    Optional<List<CustomersEntity>> findByDocumentId(@Param("document_id") String documentId);

}
