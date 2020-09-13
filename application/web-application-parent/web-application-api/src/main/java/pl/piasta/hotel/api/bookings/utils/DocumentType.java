package pl.piasta.hotel.api.bookings.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DocumentType {

    @JsonProperty("ID Card")
    IDCARD,
    @JsonProperty("Passport")
    PASSPORT

}
