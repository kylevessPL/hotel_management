package pl.piasta.hotel.api.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.piasta.hotel.api.bookings.mapper.BookingCriteriaMapper;
import pl.piasta.hotel.api.bookings.mapper.BookingMapper;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.bookings.BookingsService;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.dto.bookings.BookingDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookingsServiceController {

    private final BookingsService bookingsService;
    private final BookingMapper bookingMapper;
    private final BookingCriteriaMapper bookingCriteriaMapper;

    @PostMapping(value = "/hotel/services/bookings/book")
    public BookingDto bookAndGetSummary(@RequestBody @Valid BookingRequest bookingRequest) {
        try {
            return bookingMapper.mapToDto(bookingsService.bookAndGetSummary(
                    bookingRequest.getRoomId(),
                    bookingRequest.getAdditionalServices(),
                    bookingCriteriaMapper.mapToCustomerParam(bookingRequest),
                    bookingCriteriaMapper.mapToDateParam(bookingRequest)));
        } catch (RoomNotFoundException | AdditionalServiceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex);
        } catch (RoomNotAvailableException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getLocalizedMessage(), ex);
        }
    }

}
