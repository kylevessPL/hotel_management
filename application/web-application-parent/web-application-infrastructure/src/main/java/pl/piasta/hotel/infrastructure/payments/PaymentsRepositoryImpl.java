package pl.piasta.hotel.infrastructure.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void savePayment(PaymentDetails paymentDetails) {
        PaymentsEntity payment = new PaymentsEntity();
        updateEntity(payment, paymentDetails);
        dao.save(payment);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer getBookingPaymentFormId(Integer bookingId) {
        return dao.findByBookingId(bookingId).getPaymentFormId();
    }

    void updateEntity(PaymentsEntity payment, PaymentDetails paymentDetails) {
        payment.setBookingId(paymentDetails.getBookingId());
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
        payment.setPaymentFormId(paymentDetails.getPaymentFormId());
        payment.setTransactionId(paymentDetails.getTransationId());
    }

}
