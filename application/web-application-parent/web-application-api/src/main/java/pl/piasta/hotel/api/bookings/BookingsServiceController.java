package pl.piasta.hotel.api.bookings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import pl.piasta.hotel.dto.bookings.BookingInfoResponse;
import pl.piasta.hotel.dto.bookings.BookingResponse;

import javax.validation.Valid;

@Api
@RestController
@RequiredArgsConstructor
public class BookingsServiceController {

    private final BookingsService bookingsService;
    private final BookingMapper bookingMapper;

    @ApiOperation(
            value = "Book a room",
            notes = "You are required to pass booking details",
            nickname = "book"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully booked a room and retrieved booking details"),
            @ApiResponse(code = 400, message = "Booking information not valid"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/hotel/services/bookings/book", produces = "application/json")
    public BookingResponse book(@ApiParam(value = "Request body") @RequestBody @Valid BookingRequest bookingRequest) {
        try {
            return bookingMapper.mapToResponse(bookingsService.bookAndGetSummary(
                    bookingMapper.mapToCommand(bookingRequest))
            );
        } catch (RoomNotFoundException |
                AdditionalServiceNotFoundException |
                RoomNotAvailableException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @ApiOperation(
            value = "Confirm booking",
            notes = "You are required to pass booking details",
            nickname = "confirmBooking"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Booking information not valid"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(value = "/hotel/services/bookings/confirm", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmBooking(@ApiParam(value = "Request body") @RequestBody @Valid BookingConfirmationRequest bookingConfirmationRequest) {
        try {
            bookingsService.confirmBooking(bookingMapper.mapToCommand(bookingConfirmationRequest));
        } catch (BookingNotFoundException | PaymentFormNotFoundException | BookingAlreadyConfirmedException | BookingAlreadyCancelledException | BookingExpiredException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @ApiOperation(
            value = "Cancel booking",
            notes = "You are required to pass booking details",
            nickname = "cancelBooking"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 400, message = "Booking information not valid"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping(value = "/hotel/services/bookings/cancel", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@ApiParam(value = "Request body") @RequestBody @Valid BookingCancellationRequest bookingCancellationRequest) {
        try {
            bookingsService.cancelBooking(bookingMapper.mapToCommand(bookingCancellationRequest));
        } catch (BookingNotFoundException | BookingNotOwnedException | BookingExpiredException | BookingAlreadyCancelledException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @ApiOperation(
            value = "Get booking information",
            notes = "You are required to pass booking id as a parameter",
            nickname = "getBookingInfo"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Booking id not valid"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(value = "/hotel/services/bookings", produces = "application/json")
    public BookingInfoResponse getBookingInfo(@ApiParam(value = "Booking id") @RequestParam Integer id) {
        try {
            return bookingMapper.mapToResponse(bookingsService.getBookingInfo(id));
        } catch (BookingNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

}
