package pl.piasta.hotel.dto.additionalservices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdditionalServiceDto {

    private int id;
    private String name;
    private BigDecimal price;

}
