package pl.piasta.hotel.api.rooms.utils;

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

    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @ValidateString(acceptedValues = {"bedAmount", "standardPrice", "id"})
    private String sortBy = "id";
    @ValidateString(acceptedValues = {"ASC", "DESC"})
    private String sortDir = "ASC";

}
