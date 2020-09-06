package pl.piasta.hotel.api.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.piasta.hotel.api.utils.ValidateString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public final class RoomCriteria {

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @ValidateString(acceptedValues = {"bedAmount", "standardPrice", "id"})
    private String sortBy = "id";
    @ValidateString(acceptedValues = {"ASC", "DESC"})
    private String sortDir = "ASC";

}
