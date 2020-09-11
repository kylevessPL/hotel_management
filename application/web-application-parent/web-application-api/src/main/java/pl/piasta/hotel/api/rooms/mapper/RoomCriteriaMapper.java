package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.api.rooms.utils.RoomCriteria;
import pl.piasta.hotel.domain.model.rooms.utils.DateParam;
import pl.piasta.hotel.domain.model.rooms.utils.SortParam;

@Mapper(componentModel = "spring")
public interface RoomCriteriaMapper {

    DateParam mapToDateParam(RoomCriteria roomCriteria);
    SortParam mapToSortParam(RoomCriteria roomCriteria);

}
