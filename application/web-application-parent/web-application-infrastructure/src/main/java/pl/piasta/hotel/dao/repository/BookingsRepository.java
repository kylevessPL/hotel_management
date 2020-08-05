package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.BookingsEntity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer>, JpaSpecificationExecutor<BookingsEntity> {

    @Query(value = "Select * from bookings where book_date = :book_date", nativeQuery = true)
    Optional<List<BookingsEntity>> findByBookDate(@Param("book_date") Date bookDate);

    @Query(value = "Select * from bookings where end_date = :end_date", nativeQuery = true)
    Optional<List<BookingsEntity>>findByEndDate(@Param("end_date") Date endDate);

    @Query(value = "Select * from bookings where customer_id = :customer_id", nativeQuery = true)
    Optional<List<BookingsEntity>> findByCustomerId(@Param("customer_id") Integer customerId);

    @Query(value = "Select * from bookings where room_id = :room_id", nativeQuery = true)
    Optional<List<BookingsEntity>> findByRoomId(@Param("room_id") Integer roomId);

    @Query(value = "Select * from bookings where offer_id = :offer_id", nativeQuery = true)
    Optional<List<BookingsEntity>> findByOfferId(@Param("offer_id") Integer offerId);

    @Query(value = "Select * from bookings where final_price = :final_price", nativeQuery = true)
    Optional<List<BookingsEntity>> findByFinalPrice(@Param("final_price") BigDecimal finalPrice);

    @Query(value = "Select * from bookings where payment_id = :payment_id", nativeQuery = true)
    Optional<List<BookingsEntity>> findByPaymentId(@Param("payment_id") Integer paymentId);

}
