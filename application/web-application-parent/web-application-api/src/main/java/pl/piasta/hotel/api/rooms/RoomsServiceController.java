package pl.piasta.hotel.api.rooms;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.dto.rooms.RoomDto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoomsServiceController {

    private final RoomMapper roomMapper;
    private final RoomsService roomsService;

    @GetMapping("/hotel/services/rooms")
    public List<RoomDto> getAllAvailableRoomsWithinDateRange(@RequestParam(name = "start-date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate, @RequestParam(name = "end-date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate, @RequestParam(name = "sortby", defaultValue = "id", required = false) String sortBy) {

        List<String> sortList = Arrays.asList(sortBy.replace("-", "_").split(","));
        List<Sort.Order> sortParams = sortList.stream()
                .map(s -> new Sort.Order(Sort.Direction.ASC, s))
                .filter(StringUtils::isEmpty)
                .collect(Collectors.toList());

        return roomMapper.mapToDto(roomsService.getAllAvailableRoomsWithinDateRange(Date.valueOf(startDate), Date.valueOf(endDate), PageRequest.of(0, 50, Sort.by(sortParams))));
    }

}

