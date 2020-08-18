package pl.piasta.hotel.api.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public final class DateCriteria {

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate startDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;

}
