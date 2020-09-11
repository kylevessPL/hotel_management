package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "special_offers")
@Getter
@Setter
public class SpecialOffersEntity {

    @Id @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "bookings_amount")
    private Integer bookingsAmount;
    @Column(name = "description", length = 100)
    private String description;

}
