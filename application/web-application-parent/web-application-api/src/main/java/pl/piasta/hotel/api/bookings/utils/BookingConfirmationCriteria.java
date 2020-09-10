package pl.piasta.hotel.api.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public final class BookingConfirmationCriteria implements Serializable {

    @NotNull
    @Min(1)
    Integer bookingId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z \\-.']*$")
    @Size(min = 2, max = 20)
    String paymentForm;
    @NotBlank
    @Pattern(regexp = "^[a-z0-9 \\-]{36}$")
    String transationId;

}
