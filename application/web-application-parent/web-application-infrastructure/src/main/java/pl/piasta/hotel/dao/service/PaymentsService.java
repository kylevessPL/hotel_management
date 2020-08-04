package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.PaymentsEntity;
import pl.piasta.hotel.dao.repository.PaymentsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentsService {

	private final PaymentsRepository paymentsRepository;

	@Autowired
	public PaymentsService(PaymentsRepository paymentsRepository) {
		this.paymentsRepository = paymentsRepository;
	}

	public List<PaymentsEntity> findAll() {
		return paymentsRepository.findAll();
	}

	public PaymentsEntity findById(Integer id) {
		return paymentsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public long count() {
		return paymentsRepository.count();
	}

	public void delete(PaymentsEntity paymentsEntity) {
		paymentsRepository.delete(paymentsEntity);
	}

	public void save(PaymentsEntity paymentsEntity) {
		if (paymentsEntity == null) {
			return;
		}
		paymentsRepository.save(paymentsEntity);
	}

}
