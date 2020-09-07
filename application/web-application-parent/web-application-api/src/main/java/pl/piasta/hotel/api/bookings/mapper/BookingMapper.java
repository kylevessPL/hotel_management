package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.api.additionalservices.mapper.AdditionalServiceMapper;
import pl.piasta.hotel.api.rooms.mapper.RoomMapper;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.dto.bookings.BookingDto;

@Mapper(uses = {CustomerMapper.class, AdditionalServiceMapper.class, PaymentFormMapper.class, RoomMapper.class}, componentModel = "spring")
public interface BookingMapper {

    BookingDto mapToDto(Booking booking);

}
