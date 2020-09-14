package pl.piasta.hotel.api.bookings.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.piasta.hotel.domain.model.customers.utils.DocumentType;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public final class BookingRequest implements Serializable {

    @NotNull
    @Min(1)
    private Integer roomId;
    private Integer[] additionalServices;
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;
    @NotBlank
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
    @Size(min = 2, max = 30)
    private String city;
    @NotNull
    private DocumentType documentType;
    @NotBlank
    @Pattern(regexp = "^[0-9A-Z ]*$")
    @Size(min = 2, max = 10)
    private String documentId;

}
