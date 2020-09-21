package pl.piasta.hotel.dto.bookings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.bookings.utils.BookingPeriod;
import pl.piasta.hotel.dto.bookings.utils.PaymentStatus;
import pl.piasta.hotel.dto.rooms.RoomInfoDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingInfoDto {

    private BookingPeriod period;
    private RoomInfoDto room;
    private PaymentStatus paymentStatus;

}
