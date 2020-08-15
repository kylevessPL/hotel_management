package pl.piasta.hotel.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class RoomsEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "room_number", nullable = false, length = 10)
    private String roomNumber;
    @Column(name = "bed_amount", nullable = false)
    private int bedAmount;
    @Column(name = "standard_price", precision = 2)
    private BigDecimal standardPrice;

    @OneToMany
    @JoinTable(name = "room_amenities",
            joinColumns = { @JoinColumn(name="room_id", referencedColumnName="id") },
            inverseJoinColumns = { @JoinColumn(name="amenity_id", referencedColumnName="id", unique=true) })

    private List<AmenitiesEntity> amenitiesEntities;

}
