package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.amenities.Amenity;
import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.dto.amenities.AmenityDto;
import pl.piasta.hotel.dto.bookings.BookingDto;

import java.util.List;

@Mapper(uses = {CustomerMapper.class, PaymentFormMapper.class}, componentModel = "spring")
public interface BookingMapper {

    BookingDto mapToDto(Booking booking);

}
