package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.math.BigDecimal;
import java.util.List;

public interface AdditionalServicesService {

	List<AdditionalServicesEntity> findAll();
	AdditionalServicesEntity findById(Integer id);

	@Query(value = "Select * from additional_services where name = :name", nativeQuery = true)
	List<AdditionalServicesEntity> findByName(@Param("name") String name);

	@Query(value = "Select * from additional_services where price = :price", nativeQuery = true)
	List<AdditionalServicesEntity> findByPrice(@Param("price") BigDecimal price);

	long count();
	void delete(AdditionalServicesEntity additionalServicesEntity);
	void save(AdditionalServicesEntity additionalServicesEntity);

}
