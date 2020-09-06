package pl.piasta.hotel.domain.model.bookings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.paymentforms.PaymentForm;
import pl.piasta.hotel.domain.model.rooms.Room;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Booking {

    private final Customer customer;
    private final Room room;
    private final String[] additionalServices;
    private final Date startDate;
    private final Date endDate;
    private final BigDecimal finalPrice;
    private final List<PaymentForm> paymentForms;
    
}
