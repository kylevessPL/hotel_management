package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class RoomsEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "room_number", nullable = false, length = 10)
    private String roomNumber;
    @Column(name = "bed_amount", nullable = false)
    private Integer bedAmount;
    @Column(name = "standard_price", precision = 2)
    private BigDecimal standardPrice;

}
