package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings_services")
@Getter
@Setter
public class BookingsServicesEntity {

    @Id @Column(name = "booking_id", nullable = false) @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookingId;
    @Column(name = "service_id", nullable = false)
    private Integer serviceId;

}
