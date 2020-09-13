package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.api.bookings.utils.BookingRequest;
import pl.piasta.hotel.domain.model.customers.utils.CustomerDetails;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;

@Mapper(componentModel = "spring")
public interface BookingCriteriaMapper {

    DateDetails mapToDateDetails(BookingRequest bookingRequest);
    CustomerDetails mapToCustomerDetails(BookingRequest bookingRequest);

}
