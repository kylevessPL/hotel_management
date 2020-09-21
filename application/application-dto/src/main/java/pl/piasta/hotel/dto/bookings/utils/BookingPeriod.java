package pl.piasta.hotel.dto.bookings.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class BookingPeriod {

    Date startDate;
    Date endDate;

}
