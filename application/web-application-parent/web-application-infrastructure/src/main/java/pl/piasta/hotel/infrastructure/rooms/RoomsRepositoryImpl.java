package pl.piasta.hotel.infrastructure.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsRepository;
import pl.piasta.hotel.infrastructure.dao.RoomsEntityDao;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RoomsRepositoryImpl implements RoomsRepository {

    private final RoomsEntityDao dao;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate, Pageable pageable) {
        return dao.findAllAvailableWithinDateRange(startDate, endDate, pageable).stream()
                .distinct().map(entity -> new Room(
                        entity.getId(),
                        entity.getBedAmount(),
                        entity.getStandardPrice(),
                        entity.getAmenitiesEntities().stream()
                                .map(amenity -> new Amenity(amenity.getName()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
