package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.AdditionalServicesEntity;
import pl.piasta.hotel.infrastructure.model.PaymentFormsEntity;

public interface PaymentFormsEntityDao extends JpaRepository<PaymentFormsEntity, Integer> {
}
