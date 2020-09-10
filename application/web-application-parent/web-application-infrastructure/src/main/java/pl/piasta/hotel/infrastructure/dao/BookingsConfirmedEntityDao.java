package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.BookingsConfirmedEntity;

import java.util.Optional;

public interface BookingsConfirmedEntityDao extends JpaRepository<BookingsConfirmedEntity, Integer> {

    Optional<BookingsConfirmedEntity> findByBookingId(Integer bookingId);

}
