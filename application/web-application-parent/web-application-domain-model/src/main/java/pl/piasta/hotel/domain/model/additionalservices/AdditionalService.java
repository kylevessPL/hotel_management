package pl.piasta.hotel.domain.model.additionalservices;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdditionalService {

    private final int id;
    private final String name;
    private final BigDecimal price;

}
