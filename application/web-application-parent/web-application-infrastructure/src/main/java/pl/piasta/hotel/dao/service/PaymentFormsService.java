package pl.piasta.hotel.dao.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;

import java.util.List;

public interface PaymentFormsService {

	List<PaymentFormsEntity> findAll();
	PaymentFormsEntity findById(Integer id);

	@Query(value = "Select * from payment_forms where name = :name", nativeQuery = true)
	PaymentFormsEntity findByName(@Param("name") String name);

	long count();
	void delete(PaymentFormsEntity paymentFormsEntity);
	void save(PaymentFormsEntity paymentFormsEntity);

}
