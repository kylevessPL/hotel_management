package pl.piasta.hotel.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rooms", schema = "public", catalog = "hotel-db")
public class RoomsEntity {
    private int id;
    private String roomNumber;
    private int bedAmount;
    private BigDecimal standardPrice;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "room_number", nullable = false, length = 10)
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "bed_amount", nullable = false)
    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    @Basic
    @Column(name = "standard_price", nullable = true, precision = 2)
    public BigDecimal getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        this.standardPrice = standardPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomsEntity that = (RoomsEntity) o;
        return id == that.id &&
                bedAmount == that.bedAmount &&
                Objects.equals(roomNumber, that.roomNumber) &&
                Objects.equals(standardPrice, that.standardPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, bedAmount, standardPrice);
    }
}
