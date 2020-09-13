package pl.piasta.hotel.domain.model.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Booking {

    private final Integer bookingId;
    private final BigDecimal finalPrice;
    private final List<PaymentForm> paymentForms;
    
}
