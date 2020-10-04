package pl.piasta.hotel.application.rooms;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import pl.piasta.hotel.application.BaseIT;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;

public class RoomsServiceControllerWireMockTest extends BaseIT {

    private static final String ENDPOINT_URL = "/hotel/services/rooms?startDate=04-11-2050&endDate=05-11-2050";

    @Test
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Rooms() {
        stubFor(get(urlEqualTo(ENDPOINT_URL))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBodyFile("rooms-1.json")));
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(3))
                .body("id", hasItems(1, 2, 3));
    }

    @Test
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Except_One_Booked() {
        stubFor(get(urlEqualTo(ENDPOINT_URL))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBodyFile("rooms-2.json")));
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(2))
                .body("id", hasItems(2, 3));
    }

    @Test
    public void getAllAvailableRoomsWithinDateRange_Should_Return_No_Rooms() {
        stubFor(get(urlEqualTo(ENDPOINT_URL))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBody("[]")));
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("isEmpty()", is(true));
    }

}