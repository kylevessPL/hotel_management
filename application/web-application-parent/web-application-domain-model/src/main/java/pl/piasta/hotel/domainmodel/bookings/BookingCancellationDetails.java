package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BookingCancellationDetails {

    private final Integer customerId;
    private final BookingDate bookingDate;
    private final BookingStatus bookingStatus;
    
}
