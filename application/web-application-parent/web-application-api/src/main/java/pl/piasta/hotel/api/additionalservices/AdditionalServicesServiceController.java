package pl.piasta.hotel.api.additionalservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.api.additionalservices.mapper.AdditionalServiceMapper;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceResponse;

import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
public class AdditionalServicesServiceController {

    private final AdditionalServiceMapper additionalServiceMapper;
    private final AdditionalServicesService additionalServicesService;

    @ApiOperation(
            value = "Get all additional services",
            nickname = "getAllAdditionalServices"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 500, message = "Internal server error"),
    })
    @GetMapping(value = "/hotel/services/additional-services", produces = "application/json")
    public List<AdditionalServiceResponse> getAllAdditionalServices() {
        return additionalServiceMapper.mapToResponse(additionalServicesService.getAllAdditionalServices());
    }

}

