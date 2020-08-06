package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;
import pl.piasta.hotel.dao.repository.SpecialOffersRepository;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class SpecialOffersServiceImpl implements SpecialOffersService {

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
	public List<SpecialOffersEntity> findByDiscount(BigDecimal discount) {
		return specialOffersRepository.findByDiscount(discount).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<SpecialOffersEntity> findByBookingsAmount(Integer bookingsAmount) {
		return specialOffersRepository.findByBookingsAmount(bookingsAmount).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<SpecialOffersEntity> findByDescription(String description) {
		return specialOffersRepository.findByDescription(description).orElseThrow(EntityNotFoundException::new);
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
