package pl.piasta.hotel.api.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.piasta.hotel.domain.model.utils.BookingException;

@ControllerAdvice
public final class GlobalExceptionHandler {

    private static final int BAD_REQUEST = 400;

    private final static String VALIDATION_FAILED_CODE = "V06";

    @ExceptionHandler(value = BookingException.class)
    public ResponseEntity<ErrorResponse> bookingExceptionHandler(BookingException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                BAD_REQUEST,
                ex.getErrorCode().getCode(),
                ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            IllegalArgumentException.class
    })
    public ResponseEntity<ErrorResponse> validationFailedExceptionHandler() {
        ErrorResponse errorResponse = new ErrorResponse(
                BAD_REQUEST,
                VALIDATION_FAILED_CODE,
                "Validation failed for provided parameters");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
