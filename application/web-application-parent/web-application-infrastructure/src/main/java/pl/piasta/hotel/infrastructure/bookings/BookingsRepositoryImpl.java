package pl.piasta.hotel.infrastructure.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.bookings.BookingsRepository;
import pl.piasta.hotel.domain.model.bookings.utils.BookingDetails;
import pl.piasta.hotel.domain.model.rooms.utils.DateDetails;
import pl.piasta.hotel.infrastructure.dao.BookingsEntityDao;
import pl.piasta.hotel.infrastructure.model.BookingsEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookingsRepositoryImpl implements BookingsRepository {

    private final BookingsEntityDao dao;

    @Override
    public List<Integer> getBookingsRoomIdBetweenDates(DateDetails dateDetails) {
        Date startDate = dateDetails.getStartDate();
        Date endDate = dateDetails.getEndDate();
        return dao.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate)
                .stream()
                .map(BookingsEntity::getRoomId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Integer saveBookingAndGetId(BookingDetails bookingDetails) {
        BookingsEntity booking = new BookingsEntity();
        updateEntity(booking, bookingDetails);
        return dao.saveAndFlush(booking).getId();
    }

    void updateEntity(BookingsEntity booking, BookingDetails bookingDetails) {
        booking.setBookDate(new Timestamp(System.currentTimeMillis()));
        booking.setStartDate(bookingDetails.getDateDetails().getStartDate());
        booking.setEndDate(bookingDetails.getDateDetails().getEndDate());
        booking.setCustomerId(bookingDetails.getCustomerId());
        booking.setRoomId(bookingDetails.getRoomDetails().getRoomId());
        booking.setFinalPrice(bookingDetails.getFinalPrice());
    }

}
