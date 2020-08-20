package pl.piasta.hotel.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.utils.DateParam;
import pl.piasta.hotel.domain.model.rooms.utils.SortDir;
import pl.piasta.hotel.domain.model.rooms.utils.SortParam;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository repository;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(DateParam dateParam, SortParam sortParam) {
        Date startDate = dateParam.getStartDate();
        Date endDate = dateParam.getEndDate();
        List<Room> rooms = repository.getAllAvailableRoomsWithinDateRange(startDate, endDate);
        if(sortParam != null) {
            Comparator<Room> comparator;
            if(sortParam.getSortBy().equals("bedAmount")) {
                comparator = Comparator.comparing(Room::getBedAmount).thenComparing(Room::getStandardPrice);
            } else {
                comparator = Comparator.comparing(Room::getStandardPrice).thenComparing(Room::getBedAmount);
            }
            if(sortParam.getSortDir() == SortDir.ASC) {
                rooms.sort(comparator);
            } else {
                rooms.sort(comparator.reversed());
            }
        }
        return rooms;
    }

}
