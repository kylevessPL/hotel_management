package pl.piasta.hotel.infrastructure.paymentforms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.paymentforms.PaymentFormsRepository;
import pl.piasta.hotel.infrastructure.dao.PaymentFormsEntityDao;
import pl.piasta.hotel.infrastructure.mapper.PaymentFormsEntityMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PaymentFormsRepositoryImpl implements PaymentFormsRepository {

    private final PaymentFormsEntityMapper paymentFormsEntityMapper;
    private final PaymentFormsEntityDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<PaymentForm> getAllPaymentForms() {
        return paymentFormsEntityMapper.mapToPaymentForm(dao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean paymentFormExists(Integer paymentFormId) {
        return dao.existsById(paymentFormId);
    }

}
