package pl.piasta.hotel.domain.model.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SortDetails {

    private String sortBy;
    private SortDir sortDir;

}
