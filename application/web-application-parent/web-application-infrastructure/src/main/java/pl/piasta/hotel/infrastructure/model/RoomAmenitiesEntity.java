package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room_amenities")
@Getter
@Setter
public class RoomAmenitiesEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_amenities_generator")
    @SequenceGenerator(name="room_amenities_generator", sequenceName = "seq_room_amenities", allocationSize = 1)
    private Integer id;
    @Column(name = "room_id", nullable = false)
    private Integer roomId;
    @Column(name = "amenity_id", nullable = false)
    private Integer amenityId;

}
