package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.BookingsServicesEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsServicesRepository extends JpaRepository<BookingsServicesEntity, Integer>, JpaSpecificationExecutor<BookingsServicesEntity> {

    @Query(value = "Select * from bookings_services where service_id = :service_id", nativeQuery = true)
    Optional<List<BookingsServicesEntity>> findByServiceId(@Param("service_id") Integer serviceId);

}
