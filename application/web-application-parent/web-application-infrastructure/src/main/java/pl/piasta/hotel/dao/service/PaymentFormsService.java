package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.PaymentFormsEntity;

import java.util.List;

public interface PaymentFormsService {

	List<PaymentFormsEntity> findAll();
	PaymentFormsEntity findById(Integer id);
	long count();
	void delete(PaymentFormsEntity paymentFormsEntity);
	void save(PaymentFormsEntity paymentFormsEntity);

}
