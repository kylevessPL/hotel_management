package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.piasta.hotel.api.bookings.BookingCancellationRequest;
import pl.piasta.hotel.api.bookings.BookingConfirmationRequest;
import pl.piasta.hotel.api.bookings.BookingRequest;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.domainmodel.bookings.Booking;
import pl.piasta.hotel.domainmodel.bookings.BookingCancellationCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingConfirmationCommand;
import pl.piasta.hotel.domainmodel.bookings.BookingInfo;
import pl.piasta.hotel.dto.bookings.BookingInfoResponse;
import pl.piasta.hotel.dto.bookings.BookingResponse;

@Mapper(uses = {PaymentFormMapper.class, RoomMapper.class})
public interface BookingMapper {

    BookingResponse mapToResponse(Booking booking);
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
    BookingCancellationCommand mapToCommand(BookingCancellationRequest bookingCancellationRequest);
    BookingConfirmationCommand mapToCommand(BookingConfirmationRequest bookingConfirmationRequest);
    @Mapping(source = "startDate", target = "period.startDate")
    @Mapping(source = "endDate", target = "period.endDate")
    BookingInfoResponse mapToResponse(BookingInfo bookingInfo);

}
