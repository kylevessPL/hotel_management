package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;

import java.util.List;

public interface RoomAmenitiesEntityDao extends JpaRepository<RoomAmenitiesEntity, Integer> {

    @Query("select a.amenityId from RoomAmenitiesEntity a where a.roomId = :roomId")
    List<Integer> findAmenitiesIdsByRoomId(@Param("roomId") Integer roomId);

}
