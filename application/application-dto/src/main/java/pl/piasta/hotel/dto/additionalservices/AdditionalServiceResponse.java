package pl.piasta.hotel.dto.additionalservices;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Schema
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdditionalServiceResponse {

    @Schema(description = "Additional service id", example = "1")
    private int id;
    @Schema(description = "Additional service name", example = "Breakfast Pack")
    private String name;
    @Schema(description = "Additional service price", example = "19.99")
    private BigDecimal price;
}
