package pl.piasta.hotel.application.additionalservices;


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

public class AdditionalServicesServiceControllerTest extends BaseIT {

    private static final String ENDPOINT_URL = "/hotel/services/additional-services";

    @Test
    public void getAllAdditionalServices_Should_Return_All_Services() {
        stubFor(get(urlEqualTo(ENDPOINT_URL))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.OK.value())
                        .withBodyFile("additional-services.json")));
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("size()", is(4))
                .body("id", hasItems(1, 2, 3, 4))
                .body("name", hasItems("Breakfast Pack", "Lunch & Dinner Pack", "Cleaning Service", "Additional Bed"));
    }

    @Test
    public void getAllAdditionalServices_Should_No_Services() {
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

    @Test
    public void getAllAdditionalServices_Should_Return_Bad_Request() {
        stubFor(get(urlEqualTo(ENDPOINT_URL))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.BAD_REQUEST.value())));
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

}
