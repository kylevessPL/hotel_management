package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.math.BigDecimal;
import java.util.List;

public interface AdditionalServicesService {

	List<AdditionalServicesEntity> findAll();
	AdditionalServicesEntity findById(Integer id);
	List<AdditionalServicesEntity> findByName(@Param("name") String name);
	List<AdditionalServicesEntity> findByPrice(@Param("price") BigDecimal price);
	long count();
	void delete(AdditionalServicesEntity additionalServicesEntity);
	void save(AdditionalServicesEntity additionalServicesEntity);

}
