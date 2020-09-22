package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.piasta.hotel.api.bookings.utils.BookingConfirmationRequest;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.utils.BookingCommand;
import pl.piasta.hotel.domain.model.bookings.utils.BookingConfirmationCommand;
import pl.piasta.hotel.dto.bookings.BookingDto;

@Mapper(uses = {PaymentFormMapper.class, BookingCriteriaMapper.class}, componentModel = "spring")
public interface BookingMapper {

    BookingDto mapToDto(Booking booking);

    @Mapping(source = "startDate", target = "dateDetails.startDate")
    @Mapping(source = "endDate", target = "dateDetails.endDate")
    @Mapping(source = "firstName", target = "customerDetails.firstName")
    @Mapping(source = "lastName", target = "customerDetails.lastName")
    @Mapping(source = "streetName", target = "customerDetails.streetName")
    @Mapping(source = "houseNumber", target = "customerDetails.houseNumber")
    @Mapping(source = "zipCode", target = "customerDetails.zipCode")
    @Mapping(source = "city", target = "customerDetails.city")
    @Mapping(source = "documentType", target = "customerDetails.documentType")
    @Mapping(source = "documentId", target = "customerDetails.documentId")
    BookingCommand mapToCommand(BookingRequest bookingRequest);

    BookingConfirmationCommand mapToCommand(BookingConfirmationRequest bookingConfirmationRequest);

}
