package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;

import java.util.List;

public interface RoomAmenitiesEntityDao extends JpaRepository<RoomAmenitiesEntity, Integer> {

    List<RoomAmenitiesEntity> findAllByRoomIdIn(List<Integer> roomId);
    List<RoomAmenitiesEntity> findAllByRoomId(Integer roomId);

}
