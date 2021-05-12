package pl.piasta.hotel.api.bookings;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
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
import pl.piasta.hotel.domain.bookings.BookingsService;
import pl.piasta.hotel.dto.bookings.BookingInfoResponse;
import pl.piasta.hotel.dto.bookings.BookingResponse;

import javax.validation.Valid;

@Tag(name = "Bookings API", description = "API performing operations on booking resources")
@RestController
@RequiredArgsConstructor
public class BookingsServiceController {

    private final BookingsService bookingsService;
    private final BookingMapper bookingMapper;

    @Operation(
            summary = "Book a room",
            operationId = "makeBooking"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully booked a room and retrieved booking details"),
            @ApiResponse(responseCode = "400", description = "Booking information not valid"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(value = "/hotel/services/bookings/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse book(@ParameterObject @RequestBody @Valid BookingRequest bookingRequest) {
        return bookingMapper.mapToResponse(bookingsService.bookAndGetSummary(
                bookingMapper.mapToCommand(bookingRequest))
        );
    }

    @Operation(
            summary = "Confirm booking",
            operationId = "confirmBooking"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Booking information not valid"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(value = "/hotel/services/bookings/confirm", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmBooking(@ParameterObject @RequestBody @Valid BookingConfirmationRequest bookingConfirmationRequest) {
        bookingsService.confirmBooking(bookingMapper.mapToCommand(bookingConfirmationRequest));
    }

    @Operation(
            summary = "Cancel booking",
            operationId = "cancelBooking"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Booking information not valid"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping(value = "/hotel/services/bookings/cancel", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelBooking(@ParameterObject @RequestBody @Valid BookingCancellationRequest bookingCancellationRequest) {
        bookingsService.cancelBooking(bookingMapper.mapToCommand(bookingCancellationRequest));
    }

    @Operation(
            summary = "Get booking information",
            operationId = "getBookingInfo"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Booking id not valid"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(value = "/hotel/services/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingInfoResponse getBookingInfo(@Parameter(description = "Booking id") @RequestParam Integer id) {
        return bookingMapper.mapToResponse(bookingsService.getBookingInfo(id));
    }

}
