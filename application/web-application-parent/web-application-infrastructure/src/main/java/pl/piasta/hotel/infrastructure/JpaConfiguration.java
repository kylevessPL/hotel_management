package pl.piasta.hotel.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("pl.piasta.hotel")
public class JpaConfiguration {
}
