package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domainmodel.payments.PaymentStatus;
import pl.piasta.hotel.domainmodel.rooms.RoomInfo;

import java.sql.Date;

@RequiredArgsConstructor
@Getter
public final class BookingInfo {

    private final Date startDate;
    private final Date endDate;
    private final RoomInfo room;
    private final PaymentStatus paymentStatus;

}
