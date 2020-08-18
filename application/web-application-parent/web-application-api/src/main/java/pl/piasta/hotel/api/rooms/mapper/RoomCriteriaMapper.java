package pl.piasta.hotel.api.rooms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.piasta.hotel.api.rooms.utils.DateCriteria;
import pl.piasta.hotel.api.rooms.utils.SortCriteria;
import pl.piasta.hotel.domain.rooms.utils.DateParam;
import pl.piasta.hotel.domain.rooms.utils.SortParam;

@Mapper(componentModel = "spring")
public interface RoomCriteriaMapper {

    DateParam mapToDateParam(DateCriteria dateCriteria);
    @Mapping(source = "by", target = "sortBy")
    @Mapping(source = "dir", target = "sortDir")
    SortParam mapToSortParam(SortCriteria sortCriteria);

}
