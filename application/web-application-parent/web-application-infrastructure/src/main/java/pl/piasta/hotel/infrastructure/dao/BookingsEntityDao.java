package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

import java.sql.Date;
import java.util.List;

public interface BookingsEntityDao extends JpaRepository<BookingsEntity, Integer> {

    @Query("select bookings.roomId from BookingsEntity bookings where bookings.startDate >= :startDate and bookings.endDate <= :endDate")
    List<Integer> findRoomIdBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
