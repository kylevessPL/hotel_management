package pl.piasta.hotel.domain.model.payments.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PaymentDetails {

    private final Integer bookingId;
    private final Integer paymentFormId;
    private final String transationId;
    
}
