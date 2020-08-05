package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;

import java.util.List;

public interface PaymentFormsService {

	List<PaymentFormsEntity> findAll();
	PaymentFormsEntity findById(Integer id);
	List<PaymentFormsEntity> findByName(@Param("name") String name);
	long count();
	void delete(PaymentFormsEntity paymentFormsEntity);
	void save(PaymentFormsEntity paymentFormsEntity);

}
