package pl.piasta.hotel.application.dao.service;

import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.math.BigDecimal;
import java.util.List;

public interface AdditionalServicesService {

	List<AdditionalServicesEntity> findAll();
	AdditionalServicesEntity findById(Integer id);
	List<AdditionalServicesEntity> findByName(String name);
	List<AdditionalServicesEntity> findByPrice(BigDecimal price);
	long count();
	void delete(AdditionalServicesEntity additionalServicesEntity);
	void save(AdditionalServicesEntity additionalServicesEntity);

}
