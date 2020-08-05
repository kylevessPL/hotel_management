package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.RoomsEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomsRepository extends JpaRepository<RoomsEntity, Integer>, JpaSpecificationExecutor<RoomsEntity> {

    @Query(value = "Select * from rooms where room_number = :room_number", nativeQuery = true)
    Optional<List<RoomsEntity>> findByRoomNumber(@Param("room_number") String roomNumber);

    @Query(value = "Select * from rooms where bed_amount = :bed_amount", nativeQuery = true)
    Optional<List<RoomsEntity>> findByBedAmount(@Param("bed_amount") Integer bedAmount);

    @Query(value = "Select * from rooms where standard_price = :standard_price", nativeQuery = true)
    Optional<List<RoomsEntity>> findByStandardPrice(@Param("standard_price") BigDecimal standardPrice);

}
