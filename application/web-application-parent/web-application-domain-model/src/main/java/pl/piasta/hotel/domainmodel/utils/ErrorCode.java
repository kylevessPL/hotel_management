package pl.piasta.hotel.domainmodel.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ADDITIONAL_SERVICE_NOT_FOUND("AS04", "Additional service not found"),
    BOOKING_ALREADY_CANCELLED("B09", "Booking already cancelled"),
    BOOKING_ALREADY_CONFIRMED("B12", "Booking already confirmed"),
    BOOKING_EXPIRED("B13", "Booking expired"),
    BOOKING_NOT_FOUND("B04", "Booking not found"),
    BOOKING_NOT_OWNED("B14", "Booking not owned"),
    PAYMENT_FORM_NOT_FOUND("P04", "Payment form not found"),
    ROOM_NOT_AVAILABLE("R12", "Room not available"),
    ROOM_NOT_FOUND("R04", "Room not found"),
    VALIDATION_FAILED("V06", "Validation failed");

    private final String code;
    private final String message;

}
