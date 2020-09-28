package pl.piasta.hotel.api.rooms.utils;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.piasta.hotel.api.utils.ValidateString;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class RoomQuery {

    @ApiParam(value = "Booking start date")
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @ApiParam(value = "Booking end date")
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @ApiParam(value = "Value to sort room by", allowableValues = "bedAmount, standardPrice")
    @ValidateString(acceptedValues = {"bedAmount", "standardPrice", "id"})
    private String sortBy = "id";
    @ApiParam(value = "Sort direction", allowableValues = "ASC, DESC")
    @ValidateString(acceptedValues = {"ASC", "DESC"})
    private String sortDir = "ASC";

}
