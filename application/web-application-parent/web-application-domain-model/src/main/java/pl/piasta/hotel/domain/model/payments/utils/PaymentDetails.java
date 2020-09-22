package pl.piasta.hotel.domain.model.payments.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class PaymentDetails {

    private final Integer bookingId;
    private final Integer paymentFormId;
    private final String transationId;
    
}
