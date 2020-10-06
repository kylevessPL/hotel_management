package pl.piasta.hotel.application.additionalservices;


import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import pl.piasta.hotel.application.BaseIT;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;

import java.util.List;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@TestMethodOrder(OrderAnnotation.class)
public class AdditionalServicesServiceControllerTest extends BaseIT {

    private static final String ENDPOINT_URL = "/hotel/services/additional-services";

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @Test
    @Order(1)
    @DatabaseSetup(value = "classpath:init-additional-services-dataset.xml")
    @DatabaseTearDown(type = DELETE_ALL, value = "classpath:init-additional-services-dataset.xml")
    public void getAllAdditionalServices_Should_Return_All_Services() {
        List<AdditionalServiceResponse> response = getAdditionalServiceResponse();
        Table table = new Table(dataSource, "additional_services");
        assertThat(response, both(not(empty())).and(notNullValue()));
        Assertions.assertThat(table).hasNumberOfRows(response.size())
                .column("id").hasValues(response.get(0).getId(), response.get(1).getId())
                .column("name").hasValues(response.get(0).getName(), response.get(1).getName())
                .column("price").hasValues(response.get(0).getPrice(), response.get(1).getPrice());
    }

    @Test
    @Order(2)
    @DatabaseSetup(type = DELETE_ALL, value = "classpath:init-additional-services-dataset.xml")
    public void getAllAdditionalServices_Should_Return_No_Services() {
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .body("isEmpty()", is(true));
    }

    @Test
    @Order(3)
    @Sql(executionPhase = BEFORE_TEST_METHOD, statements = "drop table additional_services CASCADE")
    public void getAllAdditionalServices_Should_Return_No_Such_Table_Exception() {
        given()
                .when()
                .get(createURLWithPort(ENDPOINT_URL))
        .then().assertThat()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body("status", is(500))
                .body("code", is(emptyString()))
                .body("message", equalTo(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }

    private List<AdditionalServiceResponse> getAdditionalServiceResponse() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(
                createURLWithPort(ENDPOINT_URL),
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<AdditionalServiceResponse>>() {})
                .getBody();
    }

}
