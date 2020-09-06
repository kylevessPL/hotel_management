package pl.piasta.hotel.api.bookings.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.piasta.hotel.api.utils.ValidateString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public final class BookingCriteria {

    @NotNull
    @Min(1)
    private Integer roomId;
    @ValidateString(acceptedValues = {"Breakfast Pack", "Lunch & Dinner Pack", "Cleaning Service", "Additional Bed"})
    private String[] additionalServices;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z \\-.']*$")
    @Size(min = 2, max = 30)
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z \\-.']*$")
    @Size(min = 2, max = 30)
    private String lastName;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z \\-.']*$")
    @Size(min = 2, max = 30)
    private String streetName;
    @NotBlank
    @Pattern(regexp = "^\\d+/?\\d*[a-zA-Z]?(?<!/)*$")
    @Size(max = 10)
    private String houseNumber;
    @NotBlank
    @Pattern(regexp = "^[0-9 \\-]*$")
    @Size(min = 2, max = 10)
    private String zipCode;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    @Size(min = 2, max = 30)
    private String city;
    @NotBlank
    @ValidateString(acceptedValues = {"ID Card", "Passport"})
    private String documentType;
    @NotBlank
    @Pattern(regexp = "^[0-9A-Z ]*$")
    @Size(min = 2, max = 10)
    private String documentId;

}
