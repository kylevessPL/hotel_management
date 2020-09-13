package pl.piasta.hotel.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private String firstName;
    private String lastName;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String documentType;
    private String documentId;

}
