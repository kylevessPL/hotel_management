package pl.piasta.hotel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;
import pl.piasta.hotel.dao.repository.PaymentFormsRepository;
import pl.piasta.hotel.dao.service.PaymentFormsService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public abstract class PaymentFormsServiceImpl implements PaymentFormsService {

	private final PaymentFormsRepository paymentFormsRepository;

	@Autowired
	public PaymentFormsServiceImpl(PaymentFormsRepository paymentFormsRepository) {
		this.paymentFormsRepository = paymentFormsRepository;
	}

	@Override
	public List<PaymentFormsEntity> findAll() {
		return paymentFormsRepository.findAll();
	}

	@Override
	public PaymentFormsEntity findById(Integer id) {
		return paymentFormsRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public long count() {
		return paymentFormsRepository.count();
	}

	@Override
	public void delete(PaymentFormsEntity paymentFormsEntity) {
		paymentFormsRepository.delete(paymentFormsEntity);
	}

	@Override
	public void save(PaymentFormsEntity paymentFormsEntity) {
		if (paymentFormsEntity == null) {
			return;
		}
		paymentFormsRepository.save(paymentFormsEntity);
	}

}
