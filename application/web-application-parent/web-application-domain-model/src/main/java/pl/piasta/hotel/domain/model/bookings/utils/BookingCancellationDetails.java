package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domain.model.bookings.BookingDate;

@RequiredArgsConstructor
@Getter
public final class BookingCancellationDetails {

    private final Integer customerId;
    private final BookingDate bookingDate;
    private final BookingStatus bookingStatus;
    
}
