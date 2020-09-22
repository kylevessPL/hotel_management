package pl.piasta.hotel.infrastructure.bookingsservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.piasta.hotel.domain.bookingsservices.BookingsServicesRepository;
import pl.piasta.hotel.infrastructure.dao.BookingsServicesEntityDao;
import pl.piasta.hotel.infrastructure.model.BookingsServicesEntity;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingsServicesRepositoryImpl implements BookingsServicesRepository {

    private final BookingsServicesEntityDao dao;

    @Override
    @Transactional
    public void saveBookingServices(Integer bookingId, List<Integer> additionalServices) {
        additionalServices.forEach(additionalService -> {
            BookingsServicesEntity bookingService = new BookingsServicesEntity();
            updateEntity(bookingService, bookingId, additionalService);
            dao.save(bookingService);
        });
    }

    void updateEntity(BookingsServicesEntity bookingService, Integer bookingId, Integer additionalService) {
        bookingService.setBookingId(bookingId);
        bookingService.setServiceId(additionalService);
    }

}
