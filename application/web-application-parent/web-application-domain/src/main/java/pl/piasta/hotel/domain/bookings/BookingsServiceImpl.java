package pl.piasta.hotel.domain.bookings;

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
public class BookingsServiceImpl implements BookingsService {
}
