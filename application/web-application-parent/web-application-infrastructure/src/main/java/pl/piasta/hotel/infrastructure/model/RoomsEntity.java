package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "rooms")
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
