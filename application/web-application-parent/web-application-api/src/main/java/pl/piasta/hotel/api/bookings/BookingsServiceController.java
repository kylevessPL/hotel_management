package pl.piasta.hotel.api.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.piasta.hotel.api.bookings.mapper.BookingMapper;
import pl.piasta.hotel.api.bookings.utils.BookingConfirmationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.bookings.BookingsService;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyConfirmedException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingExpiredException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.PaymentFormNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.dto.bookings.BookingDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BookingsServiceController {

    private final BookingsService bookingsService;
    private final BookingMapper bookingMapper;

    @PostMapping(value = "/hotel/services/bookings/book")
    public BookingDto bookAndGetSummary(@RequestBody @Valid BookingRequest bookingRequest) {
        try {
            return bookingMapper.mapToDto(bookingsService.bookAndGetSummary(
                    bookingMapper.mapToCommand(bookingRequest))
            );
        } catch (RoomNotFoundException |
                AdditionalServiceNotFoundException |
                RoomNotAvailableException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @PostMapping(value = "/hotel/services/bookings/confirm")
    public void confirmBooking(@RequestBody @Valid BookingConfirmationRequest bookingConfirmationRequest) {
        try {
            bookingsService.confirmBooking(bookingMapper.mapToCommand(bookingConfirmationRequest));
        } catch (BookingNotFoundException | PaymentFormNotFoundException | BookingAlreadyConfirmedException | BookingExpiredException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

}
