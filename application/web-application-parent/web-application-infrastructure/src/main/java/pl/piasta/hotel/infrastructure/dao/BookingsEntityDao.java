package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

import java.sql.Date;
import java.util.List;

public interface BookingsEntityDao extends JpaRepository<BookingsEntity, Integer> {

    List<BookingsEntity> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);

}
