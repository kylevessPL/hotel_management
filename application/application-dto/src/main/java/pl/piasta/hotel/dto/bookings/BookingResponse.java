package pl.piasta.hotel.dto.bookings;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.paymentforms.PaymentFormResponse;

import java.math.BigDecimal;
import java.util.List;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingResponse {

    @ApiModelProperty(value = "Booking id", example = "1")
    private Integer bookingId;
    @ApiModelProperty(value = "Final price", example = "1300.10")
    private BigDecimal finalPrice;
    @ApiModelProperty(value = "Available payment forms")
    private List<PaymentFormResponse> paymentForms;

}
