package pl.piasta.hotel.domain.model.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter
@Setter
public class BookingDate {

    private final Timestamp bookDate;
    private final Date startDate;
    private final Date endDate;

}
