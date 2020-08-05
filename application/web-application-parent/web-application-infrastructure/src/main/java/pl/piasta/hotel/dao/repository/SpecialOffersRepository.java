package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.SpecialOffersEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialOffersRepository extends JpaRepository<SpecialOffersEntity, Integer>, JpaSpecificationExecutor<SpecialOffersEntity> {

    @Query(value = "Select * from special_offers where discount = :discount", nativeQuery = true)
    Optional<List<SpecialOffersEntity>> findByDiscount(@Param("discount") BigDecimal discount);

    @Query(value = "Select * from special_offers where bookings_amount = :bookings_amount", nativeQuery = true)
    Optional<List<SpecialOffersEntity>> findByBookingsAmount(@Param("bookings_amount") Integer bookingsAmount);

    @Query(value = "Select * from special_offers where description = :description", nativeQuery = true)
    Optional<List<SpecialOffersEntity>> findByDescription(@Param("description") String description);

}
