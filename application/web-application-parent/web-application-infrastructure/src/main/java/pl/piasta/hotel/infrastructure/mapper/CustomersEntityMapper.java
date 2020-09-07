package pl.piasta.hotel.infrastructure.mapper;

import org.springframework.stereotype.Component;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;

@Component
public class CustomersEntityMapper {

    public Customer mapToCustomer(CustomersEntity customer) {
        return new Customer(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreetName(),
                customer.getHouseNumber(),
                customer.getZipCode(),
                customer.getCity(),
                customer.getDocumentType(),
                customer.getDocumentId()
        );
    }

    public CustomersEntity createEntity(
            String firstName,
            String lastName,
            String streetName,
            String houseNumber,
            String zipCode,
            String city,
            String documentType,
            String documentId) {
        CustomersEntity customer = new CustomersEntity();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setStreetName(streetName);
        customer.setHouseNumber(houseNumber);
        customer.setZipCode(zipCode);
        customer.setCity(city);
        customer.setDocumentType(documentType);
        customer.setDocumentId(documentId);
        return customer;
    }

    public void updateEntity(Integer customerId, CustomersEntity customer) {
        customer.setId(customerId);
    }

}
