package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;
import pl.piasta.hotel.dao.repository.AdditionalServicesRepository;
import pl.piasta.hotel.dao.service.AdditionalServicesService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class AdditionalServicesServiceImpl implements AdditionalServicesService {

	private final AdditionalServicesRepository additionalServicesRepository;

	@Autowired
	public AdditionalServicesServiceImpl(AdditionalServicesRepository additionalServicesRepository) {
		this.additionalServicesRepository = additionalServicesRepository;
	}

	@Override
	public List<AdditionalServicesEntity> findAll() {
		return additionalServicesRepository.findAll();
	}

	@Override
	public AdditionalServicesEntity findById(Integer id) {
		return additionalServicesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return additionalServicesRepository.count();
	}

	@Override
	public void delete(AdditionalServicesEntity additionalServicesEntity) {
		additionalServicesRepository.delete(additionalServicesEntity);
	}

	@Override
	public void save(AdditionalServicesEntity additionalServicesEntity) {
		if (additionalServicesEntity == null) {
			return;
		}
		additionalServicesRepository.save(additionalServicesEntity);
	}

}
