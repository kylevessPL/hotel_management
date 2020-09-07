package pl.piasta.hotel.api.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.piasta.hotel.api.bookings.mapper.BookingCriteriaMapper;
import pl.piasta.hotel.api.bookings.mapper.BookingMapper;
import pl.piasta.hotel.api.bookings.utils.BookingCriteria;
import pl.piasta.hotel.domain.bookings.BookingsService;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.dto.bookings.BookingDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookingsServiceController {

    private final BookingsService bookingsService;
    private final BookingMapper bookingMapper;
    private final BookingCriteriaMapper bookingCriteriaMapper;

    @GetMapping("/hotel/services/bookings/book")
    public BookingDto bookAndGetSummary(@Valid BookingCriteria bookingCriteria) {
        try {
            return bookingMapper.mapToDto(bookingsService.bookAndGetSummary(
                    bookingCriteria.getRoomId(),
                    bookingCriteria.getAdditionalServices(),
                    bookingCriteriaMapper.mapToCustomerParam(bookingCriteria),
                    bookingCriteriaMapper.mapToDateParam(bookingCriteria)));
        } catch (RoomNotAvailableException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getLocalizedMessage(), ex);
        }
    }

}
