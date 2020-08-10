package pl.piasta.hotel.api.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesService;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AdditionalServicesServiceController {

    private final AdditionalServicesService additionalServicesService;

    @GetMapping("/hotel/services/additional-services")
    public List<AdditionalServiceDto> getAllAdditionalServices() {
        List<AdditionalService> allAdditionalServices = additionalServicesService.getAllAdditionalServices();
        return allAdditionalServices.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @GetMapping("/hotel/services/additional-services/id/{id}")
    public AdditionalServiceDto getAdditionalServiceById(@PathVariable Integer id) {
        return map(additionalServicesService.getAdditionalServiceById(id));
    }

    @GetMapping("/hotel/services/additional-services/name/{name}")
    public List<AdditionalServiceDto> getAdditionalServicesByName(@PathVariable String name) {
        List<AdditionalService> additionalServicesByName = additionalServicesService.getAdditionalServicesByName(name);
        return additionalServicesByName.stream()
                .map(this::map)
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

