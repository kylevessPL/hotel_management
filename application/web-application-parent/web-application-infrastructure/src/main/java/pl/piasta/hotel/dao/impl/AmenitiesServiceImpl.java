package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.AmenitiesEntity;
import pl.piasta.hotel.dao.repository.AmenitiesRepository;
import pl.piasta.hotel.dao.service.AmenitiesService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class AmenitiesServiceImpl implements AmenitiesService {

	private final AmenitiesRepository amenitiesRepository;

	@Autowired
	public AmenitiesServiceImpl(AmenitiesRepository amenitiesRepository) {
		this.amenitiesRepository = amenitiesRepository;
	}

	@Override
	public List<AmenitiesEntity> findAll() {
		return amenitiesRepository.findAll();
	}

	@Override
	public AmenitiesEntity findById(Integer id) {
		return amenitiesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return amenitiesRepository.count();
	}

	@Override
	public void delete(AmenitiesEntity amenitiesEntity) {
		amenitiesRepository.delete(amenitiesEntity);
	}

	@Override
	public void save(AmenitiesEntity amenitiesEntity) {
		if (amenitiesEntity == null) {
			return;
		}
		amenitiesRepository.save(amenitiesEntity);
	}

}
