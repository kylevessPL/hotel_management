package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domainmodel.customers.CustomerDetails;
import pl.piasta.hotel.domainmodel.rooms.DateDetails;

@NoArgsConstructor
@Getter
@Setter
public class BookingCommand {

    private Integer roomId;
    private Integer[] additionalServices;
    private CustomerDetails customerDetails;
    private DateDetails dateDetails;

}
