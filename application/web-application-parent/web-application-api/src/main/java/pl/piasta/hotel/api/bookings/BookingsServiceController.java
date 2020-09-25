package pl.piasta.hotel.api.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.piasta.hotel.api.bookings.mapper.BookingMapper;
import pl.piasta.hotel.api.bookings.utils.BookingCancellationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingConfirmationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.bookings.BookingsService;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyCancelledException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyConfirmedException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingExpiredException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotOwnedException;
import pl.piasta.hotel.domain.model.bookings.utils.PaymentFormNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.dto.bookings.BookingDto;
import pl.piasta.hotel.dto.bookings.BookingInfoDto;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmBooking(@RequestBody @Valid BookingConfirmationRequest bookingConfirmationRequest) {
        try {
            bookingsService.confirmBooking(bookingMapper.mapToCommand(bookingConfirmationRequest));
        } catch (BookingNotFoundException | PaymentFormNotFoundException | BookingAlreadyConfirmedException | BookingAlreadyCancelledException | BookingExpiredException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @PutMapping(value = "/hotel/services/bookings/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@RequestBody @Valid BookingCancellationRequest bookingCancellationRequest) {
        try {
            bookingsService.cancelBooking(bookingMapper.mapToCommand(bookingCancellationRequest));
        } catch (BookingNotFoundException | BookingNotOwnedException | BookingExpiredException | BookingAlreadyCancelledException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @GetMapping(value = "/hotel/services/bookings")
    public BookingInfoDto getBookingInfo(@RequestParam Integer id) {
        try {
            return bookingMapper.mapToDto(bookingsService.getBookingInfo(id));
        } catch (BookingNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

}
