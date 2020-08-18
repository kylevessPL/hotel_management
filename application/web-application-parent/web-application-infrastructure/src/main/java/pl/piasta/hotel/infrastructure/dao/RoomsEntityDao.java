package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

import java.util.List;

public interface RoomsEntityDao extends JpaRepository<RoomsEntity, Integer> {

    List<RoomsEntity> findByIdNotIn(List<Integer> bookedRooms);

}
