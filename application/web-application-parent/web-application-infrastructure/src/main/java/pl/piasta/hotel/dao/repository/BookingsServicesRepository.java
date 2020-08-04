package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.BookingsServicesEntity;

@Repository
public interface BookingsServicesRepository extends JpaRepository<BookingsServicesEntity, Integer>, JpaSpecificationExecutor<BookingsServicesEntity> {

}
