package pl.piasta.hotel.domain.bookingsservices;

import java.util.List;

public interface BookingsServicesRepository {

    void saveBookingServices(Integer bookingId, List<Integer> additionalServices);

}
