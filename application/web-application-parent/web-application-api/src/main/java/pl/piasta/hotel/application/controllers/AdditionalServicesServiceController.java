package pl.piasta.hotel.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.application.dao.service.AdditionalServicesService;
import pl.piasta.hotel.dao.model.AdditionalServicesEntity;

import java.util.List;

@RestController
public class AdditionalServicesServiceController {

    private final AdditionalServicesService additionalServicesService;

    @Autowired
    public AdditionalServicesServiceController(AdditionalServicesService additionalServicesService) {
        this.additionalServicesService = additionalServicesService;
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
