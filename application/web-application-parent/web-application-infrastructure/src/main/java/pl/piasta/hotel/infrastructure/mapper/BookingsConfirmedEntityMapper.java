package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.infrastructure.model.BookingsConfirmedEntity;

@Component
public class BookingsConfirmedEntityMapper {

    public BookingsConfirmedEntity createEntity(
            Integer bookingId
    ) {
        BookingsConfirmedEntity bookingConfirmed = new BookingsConfirmedEntity();
        bookingConfirmed.setBookingId(bookingId);
        return bookingConfirmed;
    }

}
