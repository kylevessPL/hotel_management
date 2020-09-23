package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.bookings.BookingDate;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCancellationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationDetails;
import pl.piasta.hotel.domain.model.bookings.utils.BookingFinalDetails;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

import java.util.Optional;

@Component
public class BookingsEntityMapper {

    public Optional<BookingConfirmationDetails> mapToBookingConfirmationDetails(Optional<BookingsEntity> bookingsEntity) {
        return bookingsEntity.map(e -> new BookingConfirmationDetails(mapToBookingDate(e), e.getStatus()));
    }

    private BookingDate mapToBookingDate(BookingsEntity booking) {
        return new BookingDate(booking.getBookDate(), booking.getStartDate(), booking.getEndDate());
    }

    public Optional<BookingFinalDetails> mapToBookingFinalDetails(Optional<BookingsEntity> bookingsEntity) {
        return bookingsEntity.map(e -> new BookingFinalDetails(mapToBookingDate(e), e.getRoomId(), e.getStatus()));
    }

    public Optional<BookingCancellationDetails> mapToBookingCancellationDetails(Optional<BookingsEntity> bookingsEntity) {
        return bookingsEntity.map(e -> new BookingCancellationDetails(e.getCustomerId(), mapToBookingDate(e), e.getStatus()));
    }

}
