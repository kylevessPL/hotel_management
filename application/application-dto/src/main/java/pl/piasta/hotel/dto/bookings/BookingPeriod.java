package pl.piasta.hotel.dto.bookings;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class BookingPeriod {

    @Schema(description = "Booking start date")
    private Date startDate;
    @Schema(description = "Booking end date")
    private Date endDate;
}
