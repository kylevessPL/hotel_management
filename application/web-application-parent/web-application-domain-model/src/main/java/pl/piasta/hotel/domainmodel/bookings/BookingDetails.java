package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domainmodel.rooms.DateDetails;
import pl.piasta.hotel.domainmodel.rooms.RoomDetails;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public final class BookingDetails {

    private final DateDetails dateDetails;
    private final Integer customerId;
    private final RoomDetails roomDetails;
    private final BigDecimal finalPrice;

}
