package pl.piasta.hotel.dto.bookings;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.rooms.RoomInfoResponse;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class BookingInfoResponse {

    @Schema(description = "Booking period details")
    private BookingPeriod period;
    @Schema(description = "Booked room details")
    private RoomInfoResponse room;
    @Schema(description = "Booking payment status")
    private PaymentStatus paymentStatus;
}
