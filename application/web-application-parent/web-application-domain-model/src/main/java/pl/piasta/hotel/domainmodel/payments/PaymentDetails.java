package pl.piasta.hotel.domainmodel.payments;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class PaymentDetails {

    private final Integer bookingId;
    private final Integer paymentFormId;
    private final String transationId;
    
}
