package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;

public interface CustomersEntityDao extends JpaRepository<CustomersEntity, Integer> {

    CustomersEntity findByDocumentId(String documentId);

}
