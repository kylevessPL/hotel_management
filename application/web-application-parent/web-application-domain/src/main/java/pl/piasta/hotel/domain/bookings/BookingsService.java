package pl.piasta.hotel.domain.bookings;

import pl.piasta.hotel.domain.model.bookings.Booking;
import pl.piasta.hotel.domain.model.bookings.utils.AdditionalServiceNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingAlreadyConfirmedException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingExpiredException;
import pl.piasta.hotel.domain.model.bookings.utils.BookingNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.PaymentFormNotFoundException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotAvailableException;
import pl.piasta.hotel.domain.model.bookings.utils.RoomNotFoundException;
import pl.piasta.hotel.domain.model.customers.utils.CustomerParam;
import pl.piasta.hotel.domain.model.rooms.utils.DateParam;

public interface BookingsService {

    Booking bookAndGetSummary(
            Integer roomId,
            String[] additionalServices,
            CustomerParam customerParam,
            DateParam dateParam
    ) throws RoomNotAvailableException, RoomNotFoundException, AdditionalServiceNotFoundException;

    void confirmBooking(
            Integer bookingId,
            String paymentForm,
            String transationId
    ) throws BookingNotFoundException, PaymentFormNotFoundException, BookingAlreadyConfirmedException, BookingExpiredException;

}
