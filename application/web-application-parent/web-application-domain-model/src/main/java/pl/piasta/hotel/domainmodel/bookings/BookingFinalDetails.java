package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class BookingFinalDetails {

    private final BookingDate bookingDate;
    private final Integer roomId;
    private final BookingStatus bookingStatus;
    
}
