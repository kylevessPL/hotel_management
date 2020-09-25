package pl.piasta.hotel.domain.payments;

import pl.piasta.hotel.domain.model.payments.utils.PaymentDetails;

public interface PaymentsRepository {

    void savePayment(PaymentDetails paymentDetails);
    Integer getBookingPaymentFormId(Integer bookingId);

}
