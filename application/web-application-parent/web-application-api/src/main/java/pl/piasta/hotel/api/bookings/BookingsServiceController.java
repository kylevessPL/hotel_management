package pl.piasta.hotel.api.bookings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.bookings.mapper.BookingMapper;
import pl.piasta.hotel.api.bookings.utils.BookingCancellationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingConfirmationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.bookings.BookingsService;
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
    @PostMapping(value = "/hotel/services/bookings/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse book(@ApiParam(value = "Request body") @RequestBody @Valid BookingRequest bookingRequest) {
        return bookingMapper.mapToResponse(bookingsService.bookAndGetSummary(
                bookingMapper.mapToCommand(bookingRequest))
        );
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
    @PostMapping(value = "/hotel/services/bookings/confirm", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmBooking(@ApiParam(value = "Request body") @RequestBody @Valid BookingConfirmationRequest bookingConfirmationRequest) {
        bookingsService.confirmBooking(bookingMapper.mapToCommand(bookingConfirmationRequest));
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
    @PutMapping(value = "/hotel/services/bookings/cancel", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@ApiParam(value = "Request body") @RequestBody @Valid BookingCancellationRequest bookingCancellationRequest) {
        bookingsService.cancelBooking(bookingMapper.mapToCommand(bookingCancellationRequest));
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
    @GetMapping(value = "/hotel/services/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingInfoResponse getBookingInfo(@ApiParam(value = "Booking id") @RequestParam Integer id) {
        return bookingMapper.mapToResponse(bookingsService.getBookingInfo(id));
    }

}
