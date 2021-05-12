package pl.piasta.hotel.domainmodel.rooms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class DateDetails {

    private Date startDate;
    private Date endDate;

}
