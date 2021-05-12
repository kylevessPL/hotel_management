package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domainmodel.paymentforms.PaymentForm;
import pl.piasta.hotel.dto.paymentforms.PaymentFormResponse;

import java.util.List;

@Mapper
public interface PaymentFormMapper {

    List<PaymentFormResponse> mapToResponse(List<PaymentForm> paymentForms);

}
