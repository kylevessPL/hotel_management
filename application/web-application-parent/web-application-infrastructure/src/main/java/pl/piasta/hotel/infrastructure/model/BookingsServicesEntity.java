package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "bookings_services")
@Getter
@Setter
public class BookingsServicesEntity {

    @Id @Column(name = "booking_id", nullable = false)
    private int bookingId;
    @Column(name = "service_id", nullable = false)
    private int serviceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsServicesEntity that = (BookingsServicesEntity) o;
        return bookingId == that.bookingId &&
                serviceId == that.serviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, serviceId);
    }

}
