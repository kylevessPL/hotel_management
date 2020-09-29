package pl.piasta.hotel.api.bookings.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

@ApiModel
@NoArgsConstructor
@Getter
@Setter
public class BookingRequest implements Serializable {

    @ApiModelProperty(value = "Room id", example = "1")
    @NotNull
    @Min(1)
    private Integer roomId;
    @ApiModelProperty(value = "Additional services id's", example = "[\"1\", \"2\"]")
    private Integer[] additionalServices;
    @ApiModelProperty(value = "Booking start date")
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @ApiModelProperty(value = "Booking end date")
    @NotNull
    @Future
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;
    @ApiModelProperty(value = "Customer's first name", example = "James")
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;
    @ApiModelProperty(value = "Customer's last name", example = "Smith")
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;
    @ApiModelProperty(value = "Customer's street name", example = "Ethels Lane")
    @NotBlank
    @Size(min = 2, max = 30)
    private String streetName;
    @ApiModelProperty(value = "Customer's house number", example = "747")
    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z ./]*$")
    @Size(max = 10)
    private String houseNumber;
    @ApiModelProperty(value = "Customer's ZIP code", example = "11735")
    @NotBlank
    @Pattern(regexp = "^[0-9 \\-]*$")
    @Size(min = 2, max = 10)
    private String zipCode;
    @ApiModelProperty(value = "Customer's city", example = "Farmingdale")
    @NotBlank
    @Size(min = 2, max = 30)
    private String city;
    @ApiModelProperty(value = "Customer's document type", allowableValues = "IDCARD, PASSPORT")
    @NotNull
    private DocumentType documentType;
    @ApiModelProperty(value = "Customer's document ID", example = "SB1565402")
    @NotBlank
    @Pattern(regexp = "^[0-9A-Z ]*$")
    @Size(min = 2, max = 10)
    private String documentId;

}
