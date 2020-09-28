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
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingCancellationRequest implements Serializable {

    @ApiModelProperty(value = "Booking id", example = "1")
    @NotNull
    @Min(1)
    private Integer bookingId;
    @ApiModelProperty(value = "Customer's document ID", example = "SB1565402")
    @NotBlank
    @Pattern(regexp = "^[0-9A-Z ]*$")
    @Size(min = 2, max = 10)
    private String documentId;

}
