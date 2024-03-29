package pl.piasta.hotel.domain.paymentforms;

import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;

import java.util.List;

public interface PaymentFormsRepository {

    List<PaymentForm> getAllPaymentForms();
    boolean paymentFormExists(Integer paymentFormId);
    PaymentForm getPaymentForm(Integer paymentFormId);

}
