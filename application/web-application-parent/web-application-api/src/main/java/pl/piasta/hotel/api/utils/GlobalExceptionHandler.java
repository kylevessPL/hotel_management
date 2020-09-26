package pl.piasta.hotel.api.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.piasta.hotel.domain.model.utils.BookingException;

@ControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final int BAD_REQUEST = 400;

    @RequiredArgsConstructor
    @Getter
    private static final class ErrorResponse {
        private final int status;
        private final String code;
        private final String message;
    }

    @ExceptionHandler(value = BookingException.class)
    public ResponseEntity<ErrorResponse> bookingExceptionHandler(BookingException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                BAD_REQUEST,
                ex.getMessage(),
                ex.getDetails());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
