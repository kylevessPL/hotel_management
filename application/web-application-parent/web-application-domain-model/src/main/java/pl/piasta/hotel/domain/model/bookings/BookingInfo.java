package pl.piasta.hotel.domain.model.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domain.model.payments.utils.PaymentStatus;
import pl.piasta.hotel.domain.model.rooms.RoomInfo;

import java.sql.Date;

@RequiredArgsConstructor
@Getter
public final class BookingInfo {

    private final Date startDate;
    private final Date endDate;
    private final RoomInfo room;
    private final PaymentStatus paymentStatus;

}
