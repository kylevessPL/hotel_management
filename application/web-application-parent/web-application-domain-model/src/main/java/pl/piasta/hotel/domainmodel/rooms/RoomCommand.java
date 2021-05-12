package pl.piasta.hotel.domainmodel.rooms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoomCommand {

    private DateDetails dateDetails;
    private SortDetails sortDetails;

}
