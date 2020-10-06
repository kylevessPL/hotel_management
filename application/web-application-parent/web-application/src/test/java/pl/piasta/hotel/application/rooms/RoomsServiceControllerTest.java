package pl.piasta.hotel.application.rooms;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.assertj.db.type.Request;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import pl.piasta.hotel.application.BaseIT;
import pl.piasta.hotel.dto.rooms.RoomResponse;

import java.util.List;

import static com.github.springtestdbunit.annotation.DatabaseOperation.DELETE_ALL;
import static org.assertj.db.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@DatabaseSetup(value = "classpath:init-rooms-dataset.xml")
@DatabaseTearDown(type = DELETE_ALL, value = "classpath:init-rooms-dataset.xml")
public class RoomsServiceControllerTest extends BaseIT {

    private static final String ENDPOINT_URL = "/hotel/services/rooms?startDate=04-11-2050&endDate=05-11-2050";

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    @Test
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Rooms() {
        List<RoomResponse> response = getRoomResponse();
        Table table = new Table(dataSource, "rooms", null, new String[] {"room_number"});
        assertThat(response, both(not(empty())).and(notNullValue()));
        assertThat(table).hasNumberOfRows(response.size())
                .column("id").hasValues(response.get(0).getId(), response.get(1).getId(), response.get(2).getId())
                .column("bed_amount").hasValues(response.get(0).getBedAmount(), response.get(1).getBedAmount(), response.get(2).getBedAmount())
                .column("standard_price").hasValues(response.get(0).getStandardPrice(), response.get(1).getStandardPrice(), response.get(2).getStandardPrice());
    }

    @Test
    @DatabaseSetup(value = "classpath:book-one.xml")
    @DatabaseTearDown(type = DELETE_ALL, value = "classpath:book-one.xml")
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Except_One_Booked() {
        List<RoomResponse> response = getRoomResponse();
        Request request = new Request(dataSource,
                "select r.id, r.bed_amount, r.standard_price from rooms r where r.id not in " +
                        "(select room_id from bookings)"
        );
        assertThat(response, both(not(empty())).and(notNullValue()));
        assertThat(request).hasNumberOfRows(response.size())
                .column("id").hasValues(response.get(0).getId(), response.get(1).getId())
                .column("bed_amount").hasValues(response.get(0).getBedAmount(), response.get(1).getBedAmount())
                .column("standard_price").hasValues(response.get(0).getStandardPrice(), response.get(1).getStandardPrice());
    }

    @Test
    @DatabaseSetup(value = "classpath:book-all.xml")
    @DatabaseTearDown(type = DELETE_ALL, value = "classpath:book-all.xml")
    public void getAllAvailableRoomsWithinDateRange_Should_Return_No_Rooms() {
        List<RoomResponse> response = getRoomResponse();
        assertThat(response, is(empty()));
    }

    private List<RoomResponse> getRoomResponse() {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(
                createURLWithPort(ENDPOINT_URL),
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<RoomResponse>>() {})
                .getBody();
    }

}