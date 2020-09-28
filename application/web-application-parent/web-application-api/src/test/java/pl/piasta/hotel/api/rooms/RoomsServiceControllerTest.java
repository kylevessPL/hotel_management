package pl.piasta.hotel.api.rooms;

import lombok.RequiredArgsConstructor;
import org.assertj.db.type.Request;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.api.rooms.utils.RoomQuery;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.domain.rooms.RoomsService;
import pl.piasta.hotel.domain.rooms.RoomsServiceImpl;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = RoomsServiceController.class)
@ContextConfiguration(classes = RoomsServiceImpl.class)
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application.properties")
@AutoConfigureTestDatabase
@Transactional
@RequiredArgsConstructor
public class RoomsServiceControllerTest {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private RoomsService roomsService;

    private final RoomMapper roomMapper;

    @Test
    @Sql("add-rooms.sql")
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Rooms() {
        Table table = new Table(dataSource, "rooms", new String[] {"id"}, null);
        RoomQuery roomQuery = new RoomQuery();
        roomQuery.setStartDate(LocalDate.parse("2020-11-03"));
        roomQuery.setEndDate(LocalDate.parse("2020-11-04"));
        List<Room> rooms = roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery));
        assertThat(table).column()
                .hasNumberOfRows(rooms.size())
                .containsValues(rooms.get(0).getId(), rooms.get(1).getId(), rooms.get(2).getId());
    }

    @Test
    @Sql("book-one.sql")
    @Sql("add-customer.sql")
    @Sql(
            scripts = "clean-up-booked.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
    )
    public void getAllAvailableRoomsWithinDateRange_Should_Return_All_Except_One_Booked() {
        Request request = new Request(dataSource,
                "select r.id from rooms r where r.id not in " +
                        "(select room_id from bookings)"
        );
        RoomQuery roomQuery = new RoomQuery();
        roomQuery.setStartDate(LocalDate.parse("2020-11-03"));
        roomQuery.setEndDate(LocalDate.parse("2020-11-04"));
        List<Room> rooms = roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery));
        assertThat(request).column()
                .hasNumberOfRows(rooms.size())
                .containsValues(rooms.get(0).getId(), rooms.get(1).getId());
    }

    @Test
    @Sql("book-all.sql")
    @Sql(
            scripts = {"clean-up-booked.sql", "clean-up-rooms.sql", "clean-up-customer.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
            config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
    )
    public void getAllAvailableRoomsWithinDateRange_Should_Return_No_Rooms() {
        RoomQuery roomQuery = new RoomQuery();
        roomQuery.setStartDate(LocalDate.parse("2020-11-03"));
        roomQuery.setEndDate(LocalDate.parse("2020-11-04"));
        List<Room> rooms = roomsService.getAllAvailableRoomsWithinDateRange(roomMapper.mapToCommand(roomQuery));
        assertTrue(rooms.isEmpty());
    }

}