package pl.piasta.hotel.api.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class BookingConfirmationRequest implements Serializable {

    @NotNull
    @Min(1)
    private Integer bookingId;
    @NotNull
    @Min(1)
    private Integer paymentFormId;
    @NotBlank
    @Pattern(regexp = "^[a-z0-9 \\-]{36}$")
    private String transactionId;

}
