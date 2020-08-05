package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.RoomsEntity;
import pl.piasta.hotel.dao.repository.RoomsRepository;
import pl.piasta.hotel.dao.service.RoomsService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class RoomsServiceImpl implements RoomsService {

	private final RoomsRepository roomsRepository;

	@Autowired
	public RoomsServiceImpl(RoomsRepository roomsRepository) {
		this.roomsRepository = roomsRepository;
	}

	@Override
	public List<RoomsEntity> findAll() {
		return roomsRepository.findAll();
	}

	@Override
	public RoomsEntity findById(Integer id) {
		return roomsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return roomsRepository.count();
	}

	@Override
	public void delete(RoomsEntity roomsEntity) {
		roomsRepository.delete(roomsEntity);
	}

	@Override
	public void save(RoomsEntity roomsEntity) {
		if (roomsEntity == null) {
			return;
		}
		roomsRepository.save(roomsEntity);
	}

}
