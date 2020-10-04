package pl.piasta.hotel.application.additionalservices;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import pl.piasta.hotel.application.BaseIT;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;

import java.util.List;

public class AdditionalServiceControllerTest extends BaseIT {

    private static final String ENDPOINT_URL = "/hotel/services/additional-services";

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @Test
    void testMethod() {
        List<AdditionalServiceResponse> response = getAdditionalServiceResponse();
        Assertions.assertEquals(4, response.size());
    }

    private List<AdditionalServiceResponse> getAdditionalServiceResponse() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(
                createURLWithPort(ENDPOINT_URL),
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<AdditionalServiceResponse>>() {})
                .getBody();
    }

}
