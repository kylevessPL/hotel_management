package pl.piasta.hotel.infrastructure.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.payments.utils.PaymentDetails;
import pl.piasta.hotel.domain.payments.PaymentsRepository;
import pl.piasta.hotel.infrastructure.dao.PaymentsEntityDao;
import pl.piasta.hotel.infrastructure.model.PaymentsEntity;

import java.sql.Timestamp;

@Repository
@RequiredArgsConstructor
public class PaymentsRepositoryImpl implements PaymentsRepository {

    private final PaymentsEntityDao dao;

    @Override
    public void savePayment(PaymentDetails paymentDetails) {
        PaymentsEntity payment = new PaymentsEntity();
        updateEntity(payment, paymentDetails);
        dao.saveAndFlush(payment);
    }

    void updateEntity(PaymentsEntity payment, PaymentDetails paymentDetails) {
        payment.setBookingId(paymentDetails.getBookingId());
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
        payment.setPaymentFormId(paymentDetails.getPaymentFormId());
        payment.setTransactionId(paymentDetails.getTransationId());
    }

}
