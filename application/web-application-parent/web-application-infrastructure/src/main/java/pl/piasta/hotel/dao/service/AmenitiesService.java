package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.AmenitiesEntity;
import pl.piasta.hotel.dao.repository.AmenitiesRepository;

import java.util.List;

@Service
public class AmenitiesService {

	private final AmenitiesRepository amenitiesRepository;

	@Autowired
	public AmenitiesService(AmenitiesRepository amenitiesRepository) {
		this.amenitiesRepository = amenitiesRepository;
	}

	public List<AmenitiesEntity> findAll() {
		return amenitiesRepository.findAll();
	}

	public long count() {
		return amenitiesRepository.count();
	}

	public void delete(AmenitiesEntity amenitiesEntity) {
		amenitiesRepository.delete(amenitiesEntity);
	}

	public void save(AmenitiesEntity amenitiesEntity) {
		if (amenitiesEntity == null) {
			return;
		}
		amenitiesRepository.save(amenitiesEntity);
	}

}
