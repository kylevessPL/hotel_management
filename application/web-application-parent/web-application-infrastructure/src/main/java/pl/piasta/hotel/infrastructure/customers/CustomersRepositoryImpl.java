package pl.piasta.hotel.infrastructure.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.customers.CustomersRepository;
import pl.piasta.hotel.domainmodel.customers.CustomerDetails;
import pl.piasta.hotel.infrastructure.dao.CustomersEntityDao;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;

@Repository
@RequiredArgsConstructor
public class CustomersRepositoryImpl implements CustomersRepository {

    private final CustomersEntityDao dao;

    @Override
    @Transactional
    public Integer saveCustomerAndGetId(CustomerDetails customerDetails) {
        CustomersEntity customer = dao.findByDocumentId(customerDetails.getDocumentId()).orElseGet(CustomersEntity::new);
        updateEntity(customer, customerDetails);
        return dao.save(customer).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public String getCustomerDocumentId(Integer customerId) {
        return dao.getOne(customerId).getDocumentId();
    }

    void updateEntity(CustomersEntity customer, CustomerDetails customerDetails) {
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setStreetName(customerDetails.getStreetName());
        customer.setHouseNumber(customerDetails.getHouseNumber());
        customer.setZipCode(customerDetails.getZipCode());
        customer.setCity(customerDetails.getCity());
        customer.setDocumentType(customerDetails.getDocumentType());
        customer.setDocumentId(customerDetails.getDocumentId());
    }

}
