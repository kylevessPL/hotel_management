package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BookingConfirmationDetails {

    private final BookingDate bookingDate;
    private final BookingStatus status;
    
}
