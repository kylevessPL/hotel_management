package pl.piasta.hotel.domain.model.customers.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerParam {

    private String firstName;
    private String lastName;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String documentType;
    private String documentId;
    
}
