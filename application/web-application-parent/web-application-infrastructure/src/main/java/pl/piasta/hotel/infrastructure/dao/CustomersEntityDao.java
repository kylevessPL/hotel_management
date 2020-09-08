package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.CustomersEntity;

import java.util.Optional;

public interface CustomersEntityDao extends JpaRepository<CustomersEntity, Integer> {

    Optional<CustomersEntity> findByDocumentId(String documentId);

}
