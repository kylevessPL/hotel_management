package pl.piasta.hotel.api.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomCriteriaMapper;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.api.rooms.utils.RoomCriteria;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomCriteriaMapper roomCriteriaMapper;
    private final RoomsService roomsService;

    @GetMapping("/hotel/services/rooms")
    public List<RoomDto> getAllAvailableRoomsWithinDateRange(@Valid RoomCriteria roomCriteria) {
        return roomMapper.mapToDto(roomsService.getAllAvailableRoomsWithinDateRange(
                roomCriteriaMapper.mapToDateParam(roomCriteria),
                roomCriteriaMapper.mapToSortParam(roomCriteria)));
    }

}

