package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;
import pl.piasta.hotel.dao.repository.AdditionalServicesRepository;

import java.util.List;

@Service
public class AdditionalServicesService {

	private final AdditionalServicesRepository additionalServicesRepository;

	@Autowired
	public AdditionalServicesService(AdditionalServicesRepository additionalServicesRepository) {
		this.additionalServicesRepository = additionalServicesRepository;
	}

	public List<AdditionalServicesEntity> findAll() {
		return additionalServicesRepository.findAll();
	}

	public long count() {
		return additionalServicesRepository.count();
	}

	public void delete(AdditionalServicesEntity additionalServicesEntity) {
		additionalServicesRepository.delete(additionalServicesEntity);
	}

	public void save(AdditionalServicesEntity additionalServicesEntity) {
		if (additionalServicesEntity == null) {
			return;
		}
		additionalServicesRepository.save(additionalServicesEntity);
	}

}
