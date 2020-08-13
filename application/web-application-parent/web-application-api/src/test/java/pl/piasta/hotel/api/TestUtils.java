package pl.piasta.hotel.api;

import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

public class TestUtils {

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8
    );

}