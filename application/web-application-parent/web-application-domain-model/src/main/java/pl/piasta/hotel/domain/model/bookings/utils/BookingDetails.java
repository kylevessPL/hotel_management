package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.domain.model.rooms.utils.RoomDetails;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class BookingDetails {

    private final DateDetails dateDetails;
    private final Integer customerId;
    private final RoomDetails roomDetails;
    private final BigDecimal finalPrice;

}
