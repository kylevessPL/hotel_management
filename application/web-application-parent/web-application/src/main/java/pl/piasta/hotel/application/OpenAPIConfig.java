package pl.piasta.hotel.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {

        final String apiVersion = "1.0";
        final String apiTitle = "Hotel Management OpenAPI";
        final String apiDescription = "OpenAPI Documentation for Hotel Management";

        return new OpenAPI()
                .info(new Info()
                        .title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion));
    }
}
