package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.piasta.hotel.api.rooms.utils.RoomQuery;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.model.rooms.RoomInfo;
import pl.piasta.hotel.domain.model.rooms.utils.RoomCommand;
import pl.piasta.hotel.dto.rooms.RoomDto;
import pl.piasta.hotel.dto.rooms.RoomInfoDto;

import java.util.List;

@Mapper(uses = AmenityMapper.class, componentModel = "spring")
public interface RoomMapper {

    List<RoomDto> mapToDto(List<Room> rooms);
    RoomInfoDto mapToDto(RoomInfo room);
    @Mapping(source = "startDate", target = "dateDetails.startDate")
    @Mapping(source = "endDate", target = "dateDetails.endDate")
    @Mapping(source = "sortBy", target = "sortDetails.sortBy")
    @Mapping(source = "sortDir", target = "sortDetails.sortDir")
    RoomCommand mapToCommand(RoomQuery roomQuery);

}
