package pl.piasta.hotel.infrastructure.bookings;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesRepository;
import pl.piasta.hotel.domain.bookings.BookingsRepository;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.infrastructure.dao.AdditionalServicesEntityDao;
import pl.piasta.hotel.infrastructure.mapper.AdditionalServicesEntityMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingsRepositoryImpl implements BookingsRepository {
}
