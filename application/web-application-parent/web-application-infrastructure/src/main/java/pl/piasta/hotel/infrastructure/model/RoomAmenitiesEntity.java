package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "room_amenities")
@Getter
@Setter
public class RoomAmenitiesEntity {

    @Id @Column(name = "room_id", nullable = false)
    private int roomId;
    @Column(name = "amenity_id", nullable = false)
    private int amenityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomAmenitiesEntity that = (RoomAmenitiesEntity) o;
        return roomId == that.roomId &&
                amenityId == that.amenityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, amenityId);
    }

}
