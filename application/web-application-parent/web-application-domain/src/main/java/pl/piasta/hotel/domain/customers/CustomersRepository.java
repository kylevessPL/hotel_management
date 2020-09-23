package pl.piasta.hotel.domain.customers;

import pl.piasta.hotel.domain.model.customers.utils.CustomerDetails;

public interface CustomersRepository {

    Integer saveCustomerAndGetId(CustomerDetails customerDetails);
    String getCustomerDocumentId(Integer customerId);

}
