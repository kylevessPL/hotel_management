package pl.piasta.hotel.domain.model.paymentforms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class PaymentForm {

    private final Integer id;
    private final String name;

}
