package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.util.List;

public interface AdditionalServicesService {

	List<AdditionalServicesEntity> findAll();
	AdditionalServicesEntity findById(Integer id);
	long count();
	void delete(AdditionalServicesEntity additionalServicesEntity);
	void save(AdditionalServicesEntity additionalServicesEntity);

}
