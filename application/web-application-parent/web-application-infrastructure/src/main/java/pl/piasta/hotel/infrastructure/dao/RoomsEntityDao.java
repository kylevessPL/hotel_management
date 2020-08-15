package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.sql.Date;
import java.util.List;

public interface RoomsEntityDao extends JpaRepository<RoomsEntity, Integer> {

    @Query(value = "Select rooms.id, room_number, bed_amount, standard_price, name from rooms " +
            "left join room_amenities " +
            "on rooms.id = room_amenities.room_id " +
            "left join amenities " +
            "on amenities.id = room_amenities.amenity_id " +
            "where rooms.id not in " +
            "(Select room_id from bookings " +
            "where start_date >= :start_date and end_date <= :end_date)",
            nativeQuery = true)
    List<RoomsEntity> findAllAvailableWithinDateRange(@Param("start_date") Date startDate, @Param("end_date") Date endDate, Pageable pageable);

}
