package pl.piasta.hotel.dto.paymentforms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class PaymentFormResponse {

    @ApiModelProperty(value = "Payment form name", example = "[\"Cash\", \"Check\", \"Credit Card\", \"PayPal\", \"Western Union\"]")
    private String name;

}
