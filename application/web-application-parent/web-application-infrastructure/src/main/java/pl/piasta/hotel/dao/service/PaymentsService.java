package pl.piasta.hotel.dao.service;

import pl.piasta.hotel.dao.model.PaymentsEntity;

import java.util.List;

public interface PaymentsService {

	List<PaymentsEntity> findAll() ;
	PaymentsEntity findById(Integer id);
	long count();
	void delete(PaymentsEntity paymentsEntity);
	void save(PaymentsEntity paymentsEntity);

}
