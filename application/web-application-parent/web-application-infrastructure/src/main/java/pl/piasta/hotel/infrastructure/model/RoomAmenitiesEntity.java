package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_amenities")
@Getter
@Setter
public class RoomAmenitiesEntity {

    @Id @Column(name = "room_id", nullable = false)
    private int roomId;
    @Column(name = "amenity_id", nullable = false)
    private int amenityId;

}
