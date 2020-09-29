package pl.piasta.hotel.domain.model.utils;

import lombok.Getter;

@Getter
public class BookingException extends RuntimeException {

    private final ErrorCode errorCode;

    public BookingException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
