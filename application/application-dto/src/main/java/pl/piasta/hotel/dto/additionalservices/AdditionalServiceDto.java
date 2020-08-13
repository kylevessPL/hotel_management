package pl.piasta.hotel.dto.additionalservices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class AdditionalServiceDto {

    private int id;
    private String name;
    private BigDecimal price;

}
