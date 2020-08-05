package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.PaymentsEntity;

import java.sql.Timestamp;
import java.util.List;

public interface PaymentsService {

	List<PaymentsEntity> findAll() ;
	PaymentsEntity findById(Integer id);

	@Query(value = "Select * from payments where payment_date = :payment_date", nativeQuery = true)
	PaymentsEntity findByPaymentDate(@Param("payment_date") Timestamp paymentDate);

	@Query(value = "Select * from payments where payment_form_id = :payment_form_id", nativeQuery = true)
	PaymentsEntity findByPaymentFormId(@Param("payment_form_id") Integer paymentFormId);

	long count();
	void delete(PaymentsEntity paymentsEntity);
	void save(PaymentsEntity paymentsEntity);

}
