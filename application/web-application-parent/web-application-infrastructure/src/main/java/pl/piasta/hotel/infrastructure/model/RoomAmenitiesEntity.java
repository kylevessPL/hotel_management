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
@Table(name = "room_amenities")
@Getter
@Setter
public class RoomAmenitiesEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "room_id", nullable = false)
    private Integer roomId;
    @Column(name = "amenity_id", nullable = false)
    private Integer amenityId;

}
