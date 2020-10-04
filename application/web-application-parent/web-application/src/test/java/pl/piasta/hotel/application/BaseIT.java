package pl.piasta.hotel.application;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@SpringBootTest(classes = TestConfig.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersistenceContext.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureWireMock(port = 0)
public class BaseIT {

    @Autowired
    protected DataSource dataSource;

    @Value("${wiremock.server.port}")
    protected int port;

    protected String createURLWithPort(String path) {
        return "http://localhost:" + port + path;
    }

}
