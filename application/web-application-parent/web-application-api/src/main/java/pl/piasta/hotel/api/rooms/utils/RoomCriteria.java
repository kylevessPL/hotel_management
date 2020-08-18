package pl.piasta.hotel.api.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public final class RoomCriteria {

    @NotNull
    @Valid
    private DateCriteria dateCriteria;
    @Valid
    private SortCriteria sortCriteria;

}
