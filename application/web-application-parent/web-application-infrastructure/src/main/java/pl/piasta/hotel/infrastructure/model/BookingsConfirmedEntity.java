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
@Table(name = "bookings_confirmed")
@Getter
@Setter
public class BookingsConfirmedEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;

}
