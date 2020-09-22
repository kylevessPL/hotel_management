package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.bookings.BookingDate;

@RequiredArgsConstructor
@Getter
@Setter
public class BookingConfirmationDetails {

    private final BookingDate bookingDate;
    private final boolean confirmed;
    
}
