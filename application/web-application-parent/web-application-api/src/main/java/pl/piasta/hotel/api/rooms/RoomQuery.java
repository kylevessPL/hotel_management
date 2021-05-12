package pl.piasta.hotel.api.rooms;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.piasta.hotel.api.utils.SortDir;
import pl.piasta.hotel.api.utils.ValidateString;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class RoomQuery {

    @Parameter(
            description = "Booking start date",
            schema = @Schema(type = "date"))
    @NotNull
    @Future
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;
    @Parameter(
            description = "Booking end date",
            schema = @Schema(type = "date"))
    @NotNull
    @Future
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;
    @Parameter(
            description = "Value to sort by",
            schema = @Schema(type = "string", allowableValues = { "id, bedAmount, standardPrice" }, defaultValue = "id"))
    @ValidateString(acceptedValues = { "id", "bedAmount", "standardPrice" })
    private String sortBy = "id";
    @Parameter(description = "Sort direction")
    private SortDir sortDir = SortDir.ASC;

}
