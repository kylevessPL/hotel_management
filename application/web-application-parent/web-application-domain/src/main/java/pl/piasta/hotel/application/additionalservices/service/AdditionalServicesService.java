package pl.piasta.hotel.application.additionalservices.service;

import java.util.List;

public interface AdditionalServicesService {

	List<AdditionalServicesDTO> findAll();
	AdditionalServicesDTO findById(Integer id);
	List<AdditionalServicesDTO> findByName(String name);

}
