package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.PaymentFormsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentFormsRepository extends JpaRepository<PaymentFormsEntity, Integer>, JpaSpecificationExecutor<PaymentFormsEntity> {

    @Query(value = "Select * from payment_forms where name = :name", nativeQuery = true)
    Optional<List<PaymentFormsEntity>> findByName(@Param("name") String name);

}
