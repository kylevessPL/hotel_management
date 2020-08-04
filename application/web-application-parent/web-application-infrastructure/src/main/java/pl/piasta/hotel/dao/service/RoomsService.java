package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.RoomsEntity;
import pl.piasta.hotel.dao.repository.RoomsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomsService {

	private final RoomsRepository roomsRepository;

	@Autowired
	public RoomsService(RoomsRepository roomsRepository) {
		this.roomsRepository = roomsRepository;
	}

	public List<RoomsEntity> findAll() {
		return roomsRepository.findAll();
	}

	public RoomsEntity findById(Integer id) {
		return roomsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public long count() {
		return roomsRepository.count();
	}

	public void delete(RoomsEntity roomsEntity) {
		roomsRepository.delete(roomsEntity);
	}

	public void save(RoomsEntity roomsEntity) {
		if (roomsEntity == null) {
			return;
		}
		roomsRepository.save(roomsEntity);
	}

}
