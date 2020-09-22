package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domain.model.bookings.BookingDate;

@RequiredArgsConstructor
@Getter
public final class BookingConfirmationDetails {

    private final BookingDate bookingDate;
    private final boolean confirmed;
    
}
