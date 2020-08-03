package pl.piasta.hotel.dao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookings_services", schema = "public", catalog = "hotel-db")
public class BookingsServicesEntity {
    private int bookingId;
    private int serviceId;

    @Id
    @Column(name = "booking_id", nullable = false)
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "service_id", nullable = false)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

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
