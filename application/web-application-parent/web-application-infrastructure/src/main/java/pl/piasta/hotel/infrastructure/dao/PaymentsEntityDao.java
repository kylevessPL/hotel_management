package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.PaymentsEntity;

public interface PaymentsEntityDao extends JpaRepository<PaymentsEntity, Integer> {
}
