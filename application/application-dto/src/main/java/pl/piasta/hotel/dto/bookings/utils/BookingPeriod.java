package pl.piasta.hotel.dto.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class BookingPeriod {

    private Date startDate;
    private Date endDate;

}
