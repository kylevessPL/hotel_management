package pl.piasta.hotel.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piasta.hotel.infrastructure.model.RoomsEntity;

public interface RoomsEntityDao extends JpaRepository<RoomsEntity, Integer> {
}
