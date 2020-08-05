package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.PaymentsEntity;
import pl.piasta.hotel.dao.repository.PaymentsRepository;
import pl.piasta.hotel.dao.service.PaymentsService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class PaymentsServiceImpl implements PaymentsService {

	private final PaymentsRepository paymentsRepository;

	@Autowired
	public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}

	@Override
	public List<PaymentsEntity> findAll() {
		return paymentsRepository.findAll();
	}

	@Override
	public PaymentsEntity findById(Integer id) {
		return paymentsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return paymentsRepository.count();
	}

	@Override
	public void delete(PaymentsEntity paymentsEntity) {
		paymentsRepository.delete(paymentsEntity);
	}

	@Override
	public void save(PaymentsEntity paymentsEntity) {
		if (paymentsEntity == null) {
			return;
		}
		paymentsRepository.save(paymentsEntity);
	}

}
