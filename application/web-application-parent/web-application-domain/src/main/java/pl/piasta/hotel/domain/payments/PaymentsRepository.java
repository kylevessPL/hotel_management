package pl.piasta.hotel.domain.payments;

import pl.piasta.hotel.domainmodel.payments.PaymentDetails;

public interface PaymentsRepository {

    void savePayment(PaymentDetails paymentDetails);
    Integer getBookingPaymentFormId(Integer bookingId);

}
