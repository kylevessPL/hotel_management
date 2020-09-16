package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.api.rooms.utils.RoomCriteria;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.domain.model.rooms.utils.SortDetails;

@Mapper(componentModel = "spring")
public interface RoomCriteriaMapper {

    DateDetails mapToDateParam(RoomCriteria roomCriteria);
    SortDetails mapToSortParam(RoomCriteria roomCriteria);

}
