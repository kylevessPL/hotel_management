package pl.piasta.hotel.domain.model.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.customers.utils.CustomerDetails;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;

@NoArgsConstructor
@Getter
@Setter
public class BookingCommand {

    private Integer roomId;
    private Integer[] additionalServices;
    private CustomerDetails customerDetails;
    private DateDetails dateDetails;

}
