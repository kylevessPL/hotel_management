package pl.piasta.hotel.domain.model.customers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Customer {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String streetName;
    private final String houseNumber;
    private final String zipCode;
    private final String city;
    private final String documentType;
    private final String documentId;
    
}
