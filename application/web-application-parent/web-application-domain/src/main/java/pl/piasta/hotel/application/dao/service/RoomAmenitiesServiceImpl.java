package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;
import pl.piasta.hotel.dao.repository.RoomAmenitiesRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomAmenitiesServiceImpl implements RoomAmenitiesService {

	private final RoomAmenitiesRepository roomAmenitiesRepository;

	@Autowired
	public RoomAmenitiesServiceImpl(RoomAmenitiesRepository roomAmenitiesRepository) {
		this.roomAmenitiesRepository = roomAmenitiesRepository;
	}

	@Override
	public List<RoomAmenitiesEntity> findAll() {
		return roomAmenitiesRepository.findAll();
	}

	@Override
	public RoomAmenitiesEntity findById(Integer id) {
		return roomAmenitiesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<RoomAmenitiesEntity> findByAmenityId(Integer amenityId) {
		return roomAmenitiesRepository.findByAmenityId(amenityId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return roomAmenitiesRepository.count();
	}

	@Override
	public void delete(RoomAmenitiesEntity roomAmenitiesEntity) {
		roomAmenitiesRepository.delete(roomAmenitiesEntity);
	}

	@Override
	public void save(RoomAmenitiesEntity roomAmenitiesEntity) {
		if (roomAmenitiesEntity == null) {
			return;
		}
		roomAmenitiesRepository.save(roomAmenitiesEntity);
	}

}
