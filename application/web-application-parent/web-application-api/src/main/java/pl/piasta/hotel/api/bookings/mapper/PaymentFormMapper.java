package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.dto.paymentforms.PaymentFormDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentFormMapper {

    List<PaymentFormDto> mapToDto(List<PaymentForm> paymentForms);

}
