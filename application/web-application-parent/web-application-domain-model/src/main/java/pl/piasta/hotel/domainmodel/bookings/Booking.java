package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.piasta.hotel.domainmodel.paymentforms.PaymentForm;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Getter
public final class Booking {

    private final Integer bookingId;
    private final BigDecimal finalPrice;
    private final List<PaymentForm> paymentForms;
    
}
