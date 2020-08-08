package pl.piasta.hotel.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "rooms", schema = "public")
public class RoomsEntity {
    private int id;
    private String roomNumber;
    private int bedAmount;
    private BigDecimal standardPrice;

    public @Id @Column(name = "id", nullable = false) int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Column(name = "room_number", nullable = false, length = 10) String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public @Column(name = "bed_amount", nullable = false) int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public @Column(name = "standard_price", precision = 2) BigDecimal getStandardPrice() {
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
