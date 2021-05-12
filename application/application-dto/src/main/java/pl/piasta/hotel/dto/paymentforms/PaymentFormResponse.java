package pl.piasta.hotel.dto.paymentforms;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema
@NoArgsConstructor
@Getter
@Setter
public class PaymentFormResponse {

    @Schema(description = "Payment form id", example = "1")
    private Integer id;
    @Schema(description = "Payment form name", example = "Cash")
    private String name;
}
