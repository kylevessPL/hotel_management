package pl.piasta.hotel.api.rooms.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.piasta.hotel.domain.model.rooms.utils.SortDir;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public final class SortCriteria {

    @NotBlank
    @ValidateString(acceptedValues = {"bedAmount", "standardPrice"})
    private String sortBy;
    @NotNull
    @ValidateEnum(enumClass = SortDir.class)
    private SortDir sortDir;

}
