package pl.piasta.hotel.domainmodel.bookings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookingCancellationCommand {

    private Integer bookingId;
    private String documentId;

}
