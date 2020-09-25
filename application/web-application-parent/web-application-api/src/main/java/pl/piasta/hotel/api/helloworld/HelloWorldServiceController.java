package pl.piasta.hotel.api.helloworld;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ExampleProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.hotel.domain.helloworld.HelloWorldService;

@Api
@RestController
@RequiredArgsConstructor
public class HelloWorldServiceController {

    private final HelloWorldService dateService;

    @ApiOperation(
            value = "Displays Hello welcome message along with current datetime",
            notes = "Your name can be passed as a parameter",
            nickname = "getWelcomeMessage"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", examples = @io.swagger.annotations.Example(
                    value = @ExampleProperty(value = "Hello World!", mediaType = "text/plain"))),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @GetMapping(value = "/hello", produces = "text/plain")
    public ResponseEntity<String> getWelcomeMessage(@ApiParam(value = "This is how we call you") @RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello " + name + "! Current datetime: " + dateService.getDate());
    }

}
