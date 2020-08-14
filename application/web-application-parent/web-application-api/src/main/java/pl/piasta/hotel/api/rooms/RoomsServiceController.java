package pl.piasta.hotel.api.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomsService roomsService;

    @GetMapping("/hotel/services/rooms")
    public List<RoomDto> getAllAvailableRooms(@PageableDefault(size = 50) Pageable pageable) {
        return roomMapper.mapToDto(roomsService.getAllAvailableRooms(pageable));
    }

}

