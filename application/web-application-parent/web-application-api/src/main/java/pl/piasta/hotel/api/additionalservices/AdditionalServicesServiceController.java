package pl.piasta.hotel.api.additionalservices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.additionalservices.mapper.AdditionalServiceMapper;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdditionalServicesServiceController {

    public final AdditionalServiceMapper additionalServiceMapper;
    private final AdditionalServicesService additionalServicesService;

    @GetMapping("/hotel/services/additional-services")
    public List<AdditionalServiceDto> getAllAdditionalServices() {
        return additionalServiceMapper.additionalServicesToDto(additionalServicesService.getAllAdditionalServices());
    }

    @GetMapping("/hotel/services/additional-services/id/{id}")
    public AdditionalServiceDto getAdditionalServiceById(@PathVariable Integer id) {
        return additionalServiceMapper.additionalServiceToDto(additionalServicesService.getAdditionalServiceById(id));
    }

    @GetMapping("/hotel/services/additional-services/name/{name}")
    public List<AdditionalServiceDto> getAdditionalServicesByName(@PathVariable String name) {
        return additionalServiceMapper.additionalServicesToDto(additionalServicesService.getAdditionalServicesByName(name));
    }

}

