package pl.piasta.hotel.dto.bookings.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingPeriod {

    @ApiModelProperty(value = "Booking start date")
    private Date startDate;
    @ApiModelProperty(value = "Booking end date")
    private Date endDate;

}
