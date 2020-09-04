package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.RoomAmenitiesEntity;

public interface RoomAmenitiesEntityDao extends JpaRepository<RoomAmenitiesEntity, Integer> {
}
