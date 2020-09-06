package pl.piasta.hotel.dto.bookings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.dto.customers.CustomerDto;
import pl.piasta.hotel.dto.paymentforms.PaymentFormDto;
import pl.piasta.hotel.dto.rooms.RoomDto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {

    private CustomerDto customer;
    private RoomDto room;
    private String[] additionalServices;
    private Date startDate;
    private Date endDate;
    private BigDecimal finalPrice;
    private List<PaymentFormDto> paymentForms;

}
