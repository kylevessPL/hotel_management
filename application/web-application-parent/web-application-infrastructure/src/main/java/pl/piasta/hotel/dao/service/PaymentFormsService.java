package pl.piasta.hotel.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;
import pl.piasta.hotel.dao.repository.PaymentFormsRepository;

import java.util.List;

@Service
public class PaymentFormsService {

	private final PaymentFormsRepository paymentFormsRepository;

	@Autowired
	public PaymentFormsService(PaymentFormsRepository paymentFormsRepository) {
		this.paymentFormsRepository = paymentFormsRepository;
	}

	public List<PaymentFormsEntity> findAll() {
		return paymentFormsRepository.findAll();
	}

	public long count() {
		return paymentFormsRepository.count();
	}

	public void delete(PaymentFormsEntity paymentFormsEntity) {
		paymentFormsRepository.delete(paymentFormsEntity);
	}

	public void save(PaymentFormsEntity paymentFormsEntity) {
		if (paymentFormsEntity == null) {
			return;
		}
		paymentFormsRepository.save(paymentFormsEntity);
	}

}
