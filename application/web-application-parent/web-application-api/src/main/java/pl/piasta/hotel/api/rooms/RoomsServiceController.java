package pl.piasta.hotel.api.rooms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.api.rooms.utils.RoomQuery;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomResponse;

import javax.validation.Valid;
import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomsService roomsService;

    @ApiOperation(
            value = "Get all available rooms within date range",
            notes = "You are required to pass start and end dates as parameters; optional sorting criteria available",
            nickname = "getAllAvailableRoomsWithinDateRange"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Parameters not valid"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(value = "/hotel/services/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomResponse> getAllAvailableRoomsWithinDateRange(@Valid RoomQuery roomQuery) {
        return roomMapper.mapToResponse(roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery)));
    }

}

