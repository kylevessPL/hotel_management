package pl.piasta.hotel.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "room_amenities", schema = "public")
public class RoomAmenitiesEntity {
    private int roomId;
    private int amenityId;

    public @Id @Column(name = "room_id", nullable = false) int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public @Column(name = "amenity_id", nullable = false) int getAmenityId() {
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
