package pl.piasta.hotel.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.utils.DateParam;
import pl.piasta.hotel.domain.rooms.utils.SortDir;
import pl.piasta.hotel.domain.rooms.utils.SortParam;

import java.sql.Date;
import java.util.Collections;
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
            rooms.sort(Comparator.comparing(room ->
                    sortParam.getSortBy()
                            .equals("bedAmount") ? room.getBedAmount() : room.getStandardPrice().longValue()));
            if (sortParam.getSortDir().equals(SortDir.DESC)) {
                rooms.sort(Collections.reverseOrder());
            }
        }
        return rooms;
    }

}
