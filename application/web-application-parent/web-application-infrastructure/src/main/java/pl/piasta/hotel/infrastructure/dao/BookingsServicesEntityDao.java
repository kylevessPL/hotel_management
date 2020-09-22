package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.BookingsServicesEntity;

public interface BookingsServicesEntityDao extends JpaRepository<BookingsServicesEntity, Integer> {
}
