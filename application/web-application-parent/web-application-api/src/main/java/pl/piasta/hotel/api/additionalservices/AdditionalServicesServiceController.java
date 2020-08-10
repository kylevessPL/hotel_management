package pl.piasta.hotel.api.additionalservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.application.additionalservices.service.AdditionalServicesService;
import pl.piasta.hotel.domain.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdditionalServicesServiceController {

    private final AdditionalServicesService additionalServicesService;

    @Autowired
    public AdditionalServicesServiceController(AdditionalServicesService additionalServicesService) {
        this.additionalServicesService = additionalServicesService;
    }

    @GetMapping("/hotel/services/additional-services")
    public List<AdditionalServiceDto> getAllAdditionalServices() {
        List<AdditionalService> allAdditionalServices = additionalServicesService.getAllAdditionalServices();
        return allAdditionalServices.stream()
                .map(service -> map(service))
                .collect(Collectors.toList());
    }

    private AdditionalServiceDto map(AdditionalService additionalService) {
        AdditionalServiceDto additionalServiceDto = new AdditionalServiceDto();
        additionalServiceDto.setId(additionalService.getId());
        additionalServiceDto.setName(additionalService.getName());
        additionalServiceDto.setPrice(additionalService.getPrice());
        return additionalServiceDto;
    }

}

