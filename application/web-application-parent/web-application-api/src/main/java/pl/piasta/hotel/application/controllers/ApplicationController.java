package pl.piasta.hotel.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piasta.hotel.application.dateservice.HelloWorldService;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;
import pl.piasta.hotel.dao.service.AdditionalServicesService;

import java.util.List;

@RestController
public class ApplicationController {

    private final HelloWorldService dateService;
    private final AdditionalServicesService additionalServicesService;

    @Autowired
    public ApplicationController(HelloWorldService dateService, AdditionalServicesService additionalServicesService) {
        this.dateService = dateService;
        this.additionalServicesService = additionalServicesService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> get(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name + "! Current datetime: " + dateService.getDate());
    }

    @GetMapping("/hotel/services/additional-services")
    public List<AdditionalServicesEntity> findAdditionalServices() {
        return additionalServicesService.findAll();
    }

    @GetMapping("/hotel/services/additional-services/id/{id}")
    public AdditionalServicesEntity findAdditionalServiceById(@PathVariable Integer id) {
        return additionalServicesService.findById(id);
    }

    @GetMapping("/hotel/services/additional-services/name/{name}")
    public List<AdditionalServicesEntity> findAdditionalServiceByName(@PathVariable String name) {
        return additionalServicesService.findByName(name);
    }

}
