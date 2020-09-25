package pl.piasta.hotel.dto.additionalservices;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdditionalServiceResponse {

    @ApiModelProperty(value = "Additional service id", example = "1")
    private int id;
    @ApiModelProperty(value = "Additional service name", example = "Breakfast Pack")
    private String name;
    @ApiModelProperty(value = "Additional service price", example = "19.99")
    private BigDecimal price;

}
