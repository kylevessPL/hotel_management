package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.api.bookings.utils.BookingCriteria;
import pl.piasta.hotel.domain.model.customers.utils.CustomerParam;
import pl.piasta.hotel.domain.model.rooms.utils.DateParam;

@Mapper(componentModel = "spring")
public interface BookingCriteriaMapper {

    DateParam mapToDateParam(BookingCriteria bookingCriteria);
    CustomerParam mapToCustomerParam(BookingCriteria bookingCriteria);

}
