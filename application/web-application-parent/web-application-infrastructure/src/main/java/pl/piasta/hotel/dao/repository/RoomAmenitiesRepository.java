package pl.piasta.hotel.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.dao.model.RoomAmenitiesEntity;

@Repository
public interface RoomAmenitiesRepository extends JpaRepository<RoomAmenitiesEntity, Integer>, JpaSpecificationExecutor<RoomAmenitiesEntity> {

}
