package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Component
public class BookingsEntityMapper {

    public BookingsEntity createEntity(
            Date startDate,
            Date endDate,
            Integer customerId,
            Integer roomId,
            BigDecimal finalPrice) {
        BookingsEntity booking = new BookingsEntity();
        booking.setBookDate(new Timestamp(System.currentTimeMillis()));
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setCustomerId(customerId);
        booking.setRoomId(roomId);
        booking.setFinalPrice(finalPrice);
        return booking;
    }

}
