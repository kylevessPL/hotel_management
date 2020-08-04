package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;
import pl.piasta.hotel.dao.repository.RoomAmenitiesRepository;

import java.util.List;

@Service
public class RoomAmenitiesService {

	private final RoomAmenitiesRepository roomAmenitiesRepository;

	@Autowired
	public RoomAmenitiesService(RoomAmenitiesRepository roomAmenitiesRepository) {
		this.roomAmenitiesRepository = roomAmenitiesRepository;
	}

	public List<RoomAmenitiesEntity> findAll() {
		return roomAmenitiesRepository.findAll();
	}

	public long count() {
		return roomAmenitiesRepository.count();
	}

	public void delete(RoomAmenitiesEntity roomAmenitiesEntity) {
		roomAmenitiesRepository.delete(roomAmenitiesEntity);
	}

	public void save(RoomAmenitiesEntity roomAmenitiesEntity) {
		if (roomAmenitiesEntity == null) {
			return;
		}
		roomAmenitiesRepository.save(roomAmenitiesEntity);
	}

}
