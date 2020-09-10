package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.infrastructure.model.PaymentsEntity;

import java.sql.Timestamp;

@Component
public class PaymentsEntityMapper {

    public PaymentsEntity createEntity(
            Integer bookingId,
            Integer paymentFormId,
            String transationId
    ) {
        PaymentsEntity payment = new PaymentsEntity();
        payment.setBookingId(bookingId);
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
        payment.setPaymentFormId(paymentFormId);
        payment.setTransactionId(transationId);
        return payment;
    }

}
