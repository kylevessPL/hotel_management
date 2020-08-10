package pl.piasta.hotel.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.application.helloworld.service.HelloWorldService;

@RestController
public class HelloWorldServiceController {

    private final HelloWorldService dateService;

    @Autowired
    public HelloWorldServiceController(HelloWorldService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> get(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name + "! Current datetime: " + dateService.getDate());
    }

}