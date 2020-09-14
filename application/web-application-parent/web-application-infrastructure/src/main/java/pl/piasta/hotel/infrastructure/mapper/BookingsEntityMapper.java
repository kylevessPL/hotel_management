package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.bookings.BookingDate;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationDetails;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

@Component
public class BookingsEntityMapper {

    public BookingConfirmationDetails mapToBookingConfirmationDetails(BookingsEntity bookingsEntity) {
        BookingDate bookingDate = mapToBookingDate(bookingsEntity);
        boolean confirmed = bookingsEntity.getConfirmed();
        return new BookingConfirmationDetails(bookingDate, confirmed);
    }

    private BookingDate mapToBookingDate(BookingsEntity booking) {
        return new BookingDate(booking.getBookDate(), booking.getStartDate(), booking.getEndDate());
    }

}
