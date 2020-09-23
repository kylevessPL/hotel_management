package pl.piasta.hotel.api.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.api.rooms.utils.RoomQuery;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomsService roomsService;

    @GetMapping("/hotel/services/rooms")
    public List<RoomDto> getAllAvailableRoomsWithinDateRange(@Valid RoomQuery roomQuery) {
        return roomMapper.mapToDto(roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery)));
    }

}

