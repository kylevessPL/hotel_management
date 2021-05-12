package pl.piasta.hotel.api.rooms;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomResponse;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Rooms API", description = "API performing operations on room resources")
@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomsService roomsService;

    @Operation(
            summary = "Get all available rooms",
            operationId = "getAllAvailableRooms"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Parameters not valid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(value = "/hotel/services/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomResponse> getAllAvailableRooms(@ParameterObject @Valid RoomQuery roomQuery) {
        return roomMapper.mapToResponse(roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery)));
    }
}

