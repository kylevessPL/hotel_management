package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.PaymentFormsEntity;

import java.util.Optional;

public interface PaymentFormsEntityDao extends JpaRepository<PaymentFormsEntity, Integer> {

    Optional<PaymentFormsEntity> findByName(String name);

}
