package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.CustomersEntity;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>, JpaSpecificationExecutor<CustomersEntity> {

}
