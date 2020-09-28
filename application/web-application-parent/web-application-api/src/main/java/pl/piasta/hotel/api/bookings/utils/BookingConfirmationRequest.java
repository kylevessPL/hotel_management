package pl.piasta.hotel.api.bookings.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingConfirmationRequest implements Serializable {

    @ApiModelProperty(value = "Booking id", example = "1")
    @NotNull
    @Min(1)
    private Integer bookingId;
    @ApiModelProperty(value = "Payment form id", example = "1")
    @NotNull
    @Min(1)
    private Integer paymentFormId;
    @ApiModelProperty(value = "Transaction id", example = "a6bee8b2-8b4e-11e9-8918-07b31163120a")
    @NotBlank
    @Pattern(regexp = "^[a-z0-9 \\-]{36}$")
    private String transactionId;

}
