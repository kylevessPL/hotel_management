package pl.piasta.hotel.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("/hello")
    public ResponseEntity<String> get(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name + "!");
    }

}
