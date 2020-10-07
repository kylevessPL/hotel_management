package pl.piasta.hotel.application;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan("pl.piasta.hotel")
@EntityScan("pl.piasta.hotel")
public class TestConfig {
}
