package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookingConfirmationCommand {

    private Integer bookingId;
    private Integer paymentFormId;
    private String transactionId;

}
