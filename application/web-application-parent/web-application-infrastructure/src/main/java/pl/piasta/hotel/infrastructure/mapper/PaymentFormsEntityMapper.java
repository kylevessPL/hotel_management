package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.infrastructure.model.PaymentFormsEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentFormsEntityMapper {

    public List<PaymentForm> mapToPaymentForm(List<PaymentFormsEntity> paymentForms) {
        return paymentForms.stream()
                .map(entity -> new PaymentForm(entity.getName()))
                .collect(Collectors.toList());
    }

}
