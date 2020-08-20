package pl.piasta.hotel.domain.model.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class DateParam {

    private Date startDate;
    private Date endDate;

}
