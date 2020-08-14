package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.util.List;

public interface RoomsEntityDao extends JpaRepository<RoomsEntity, Integer> {

    @Query(value = "Select * from rooms where id not in (Select room_id from bookings)", nativeQuery = true)
    List<RoomsEntity> findAllAvailable(Pageable pageable);

}
