package pl.piasta.hotel.application.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.dao.model.PaymentsEntity;
import pl.piasta.hotel.dao.repository.PaymentsRepository;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PaymentsServiceImpl implements PaymentsService {

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
	public List<PaymentsEntity> findByBookingId(Integer bookingId) {
		return paymentsRepository.findByBookingId(bookingId).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<PaymentsEntity> findByPaymentDate(Timestamp paymentDate) {
		return paymentsRepository.findByPaymentDate(paymentDate).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<PaymentsEntity> findByPaymentFormId(Integer paymentFormId) {
		return paymentsRepository.findByPaymentFormId(paymentFormId).orElseThrow(EntityNotFoundException::new);
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
