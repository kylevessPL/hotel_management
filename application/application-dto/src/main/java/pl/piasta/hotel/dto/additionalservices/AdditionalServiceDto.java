package pl.piasta.hotel.dto.additionalservices;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
@Setter
public class AdditionalServiceDto {

    private final int id;
    private final String name;
    private final BigDecimal price;

}
