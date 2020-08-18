package pl.piasta.hotel.api.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.rooms.utils.SortDir;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public final class SortCriteria {

    @NotBlank
    @ValidateString(acceptedValues = {"bedAmount", "standardPrice"})
    private String by;
    @NotNull
    @ValidateEnum(enumClass = SortDir.class)
    private SortDir dir;

}
