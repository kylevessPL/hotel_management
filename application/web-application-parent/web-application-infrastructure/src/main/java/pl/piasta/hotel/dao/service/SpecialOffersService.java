package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;
import pl.piasta.hotel.dao.repository.SpecialOffersRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SpecialOffersService {

	private final SpecialOffersRepository specialOffersRepository;

	@Autowired
	public SpecialOffersService(SpecialOffersRepository specialOffersRepository) {
		this.specialOffersRepository = specialOffersRepository;
	}

	public List<SpecialOffersEntity> findAll() {
		return specialOffersRepository.findAll();
	}

	public SpecialOffersEntity findById(Integer id) {
		return specialOffersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public long count() {
		return specialOffersRepository.count();
	}

	public void delete(SpecialOffersEntity specialOffersEntity) {
		specialOffersRepository.delete(specialOffersEntity);
	}

	public void save(SpecialOffersEntity specialOffersEntity) {
		if (specialOffersEntity == null) {
			return;
		}
		specialOffersRepository.save(specialOffersEntity);
	}

}
