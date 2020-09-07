package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.dto.customers.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapToDto(Customer customer);

}
