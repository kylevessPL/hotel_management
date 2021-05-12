package pl.piasta.hotel.api.additionalservices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.additionalservices.mapper.AdditionalServiceMapper;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;

import java.util.List;

@Tag(name = "Additional Services API", description = "API performing operations on additional service resources")
@RestController
@RequiredArgsConstructor
public class AdditionalServicesServiceController {

    private final AdditionalServiceMapper additionalServiceMapper;
    private final AdditionalServicesService additionalServicesService;

    @Operation(
            summary = "Get all additional services",
            operationId = "getAllAdditionalServices"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    @GetMapping(value = "/hotel/services/additional-services", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdditionalServiceResponse> getAllAdditionalServices() {
        return additionalServiceMapper.mapToResponse(additionalServicesService.getAllAdditionalServices());
    }

}

