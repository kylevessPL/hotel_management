package pl.piasta.hotel.domainmodel.customers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDetails {

    private String firstName;
    private String lastName;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private DocumentType documentType;
    private String documentId;
    
}
