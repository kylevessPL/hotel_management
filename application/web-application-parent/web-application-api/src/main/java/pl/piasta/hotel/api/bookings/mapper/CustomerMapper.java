package pl.piasta.hotel.api.bookings.mapper;

import org.mapstruct.Mapper;
import pl.piasta.hotel.domain.model.customers.Customer;
import pl.piasta.hotel.domain.model.rooms.Room;
import pl.piasta.hotel.dto.customers.CustomerDto;
import pl.piasta.hotel.dto.rooms.RoomDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapToDto(List<Customer> customer);

}
