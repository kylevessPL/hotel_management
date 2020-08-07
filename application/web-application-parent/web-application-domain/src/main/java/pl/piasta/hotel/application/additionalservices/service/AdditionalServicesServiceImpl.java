package pl.piasta.hotel.application.additionalservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalServicesServiceImpl implements AdditionalServicesService {

	private final AdditionalServicesDTOMapper mapper;

	@Autowired
	AdditionalServicesServiceImpl(AdditionalServicesDTOMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<AdditionalServicesDTO> findAll() {
		return mapper.findAll();
	}

	@Override
	public AdditionalServicesDTO findById(Integer id) {
		return mapper.findById(id);
	}

	@Override
	public List<AdditionalServicesDTO> findByName(String name) {
		return mapper.findByName(name);
	}

}
