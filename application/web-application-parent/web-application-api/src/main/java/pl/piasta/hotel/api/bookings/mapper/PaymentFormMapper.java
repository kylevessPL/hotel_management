package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.dto.paymentforms.PaymentFormResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentFormMapper {

    List<PaymentFormResponse> mapToResponse(List<PaymentForm> paymentForms);

}
