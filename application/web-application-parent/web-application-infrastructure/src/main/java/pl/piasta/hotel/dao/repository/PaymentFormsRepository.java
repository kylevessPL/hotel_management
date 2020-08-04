package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;

@Repository
public interface PaymentFormsRepository extends JpaRepository<PaymentFormsEntity, Integer>, JpaSpecificationExecutor<PaymentFormsEntity> {

}
