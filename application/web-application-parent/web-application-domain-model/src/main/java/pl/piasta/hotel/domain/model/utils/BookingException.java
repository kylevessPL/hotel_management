package pl.piasta.hotel.domain.model.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BookingException extends RuntimeException {

    private final String details;

    public BookingException(String message, String details) {
        super(message);
        this.details = details;
    }

}
