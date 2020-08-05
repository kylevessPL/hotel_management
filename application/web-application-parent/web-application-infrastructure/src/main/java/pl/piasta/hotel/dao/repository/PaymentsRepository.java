package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.PaymentsEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Integer>, JpaSpecificationExecutor<PaymentsEntity> {

    @Query(value = "Select * from payments where payment_date = :payment_date", nativeQuery = true)
    Optional<List<PaymentsEntity>> findByPaymentDate(@Param("payment_date") Timestamp paymentDate);

    @Query(value = "Select * from payments where payment_form_id = :payment_form_id", nativeQuery = true)
    Optional<List<PaymentsEntity>> findByPaymentFormId(@Param("payment_form_id") Integer paymentFormId);

}
