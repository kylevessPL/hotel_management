package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.dto.rooms.RoomDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    List<RoomDto> mapToDto(List<Room> rooms);

}
