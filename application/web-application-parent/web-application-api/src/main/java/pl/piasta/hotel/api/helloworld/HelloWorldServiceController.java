package pl.piasta.hotel.api.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.domain.helloworld.HelloWorldService;

@RestController
@RequiredArgsConstructor
public class HelloWorldServiceController {

    private final HelloWorldService dateService;

    @GetMapping("/hello")
    public ResponseEntity<String> get(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name + "! Current datetime: " + dateService.getDate());
    }

}
