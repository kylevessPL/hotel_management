package pl.piasta.hotel.application.additionalservices;


import lombok.RequiredArgsConstructor;
import org.dbunit.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pl.piasta.hotel.application.BaseIT;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;
import pl.piasta.hotel.dto.rooms.RoomResponse;

import java.util.List;

public class AdditionalServiceControllerTest extends BaseIT {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @Test
    void testMethod(){
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(
                createURLWithPort("/hotel/services/additional-services"),
                List.class);
        List additionalServices = responseEntity.getBody();
        Assertions.assertEquals(4, additionalServices.size());
    }


}
