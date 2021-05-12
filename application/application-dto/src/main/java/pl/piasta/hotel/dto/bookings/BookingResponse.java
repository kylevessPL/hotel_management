package pl.piasta.hotel.dto.bookings;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.paymentforms.PaymentFormResponse;

import java.math.BigDecimal;
import java.util.List;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class BookingResponse {

    @Schema(description = "Booking id", example = "1")
    private Integer bookingId;
    @Schema(description = "Final price", example = "1300.10")
    private BigDecimal finalPrice;
    @Schema(description = "Available payment forms")
    private List<PaymentFormResponse> paymentForms;
}
