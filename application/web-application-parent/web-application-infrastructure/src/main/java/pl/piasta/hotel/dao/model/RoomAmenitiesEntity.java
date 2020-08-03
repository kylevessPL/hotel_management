package pl.piasta.hotel.dao.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room_amenities", schema = "public", catalog = "hotel-db")
public class RoomAmenitiesEntity {
    private int roomId;
    private int amenityId;

    @Id
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "amenity_id", nullable = false)
    public int getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(int amenityId) {
        this.amenityId = amenityId;
    }

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
