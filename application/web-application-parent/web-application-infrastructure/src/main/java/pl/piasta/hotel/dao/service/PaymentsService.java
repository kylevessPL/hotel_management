package pl.piasta.hotel.dao.service;

import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.PaymentsEntity;

import java.sql.Timestamp;
import java.util.List;

public interface PaymentsService {

	List<PaymentsEntity> findAll() ;
	PaymentsEntity findById(Integer id);
	List<PaymentsEntity> findByPaymentDate(@Param("payment_date") Timestamp paymentDate);
	List<PaymentsEntity> findByPaymentFormId(@Param("payment_form_id") Integer paymentFormId);
	long count();
	void delete(PaymentsEntity paymentsEntity);
	void save(PaymentsEntity paymentsEntity);

}
