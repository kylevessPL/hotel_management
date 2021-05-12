package pl.piasta.hotel.api.bookings;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class BookingConfirmationRequest implements Serializable {

    @Schema(description = "Booking id", example = "1")
    @NotNull
    @Min(1)
    private Integer bookingId;
    @Schema(description = "Payment form id", example = "1")
    @NotNull
    @Min(1)
    private Integer paymentFormId;
    @Schema(description = "Transaction id", example = "a6bee8b2-8b4e-11e9-8918-07b31163120a")
    @NotBlank
    @Pattern(regexp = "^[a-z0-9 \\-]{36}$")
    private String transactionId;

}
