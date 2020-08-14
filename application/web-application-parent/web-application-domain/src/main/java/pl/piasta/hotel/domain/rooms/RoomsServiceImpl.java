package pl.piasta.hotel.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private final RoomsRepository repository;

    @Override
    public List<Room> getAllAvailableRoomsWithinDateRange(Date startDate, Date endDate, Pageable pageable) {
        return repository.getAllAvailableRoomsWithinDateRange(startDate, endDate, pageable);
    }

}
