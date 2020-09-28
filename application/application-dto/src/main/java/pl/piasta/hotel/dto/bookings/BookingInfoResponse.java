package pl.piasta.hotel.dto.bookings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.bookings.utils.BookingPeriod;
import pl.piasta.hotel.dto.bookings.utils.PaymentStatus;
import pl.piasta.hotel.dto.rooms.RoomInfoResponse;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingInfoResponse {

    @ApiModelProperty(value = "Booking period details")
    private BookingPeriod period;
    @ApiModelProperty(value = "Booked room details")
    private RoomInfoResponse room;
    @ApiModelProperty(value = "Booking payment status", example = "PAYED")
    private PaymentStatus paymentStatus;

}
