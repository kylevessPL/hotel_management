package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;
import pl.piasta.hotel.dao.repository.SpecialOffersRepository;
import pl.piasta.hotel.dao.service.SpecialOffersService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class SpecialOffersServiceImpl implements SpecialOffersService {

	private final SpecialOffersRepository specialOffersRepository;

	@Autowired
	public SpecialOffersServiceImpl(SpecialOffersRepository specialOffersRepository) {
		this.specialOffersRepository = specialOffersRepository;
	}

	@Override
	public List<SpecialOffersEntity> findAll() {
		return specialOffersRepository.findAll();
	}

	@Override
	public SpecialOffersEntity findById(Integer id) {
		return specialOffersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return specialOffersRepository.count();
	}

	@Override
	public void delete(SpecialOffersEntity specialOffersEntity) {
		specialOffersRepository.delete(specialOffersEntity);
	}

	@Override
	public void save(SpecialOffersEntity specialOffersEntity) {
		if (specialOffersEntity == null) {
			return;
		}
		specialOffersRepository.save(specialOffersEntity);
	}

}
