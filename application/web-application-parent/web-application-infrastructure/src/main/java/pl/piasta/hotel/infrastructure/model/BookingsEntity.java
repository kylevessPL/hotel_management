package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "bookings")
@Getter
@Setter
public class BookingsEntity {

    @Id @Column(name = "id", nullable = false) @NonNull private int id;
    @Column(name = "book_date", nullable = false) @NonNull private Timestamp bookDate;
    @Column(name = "start_date", nullable = false) @NonNull private Date startDate;
    @Column(name = "end_date", nullable = false) @NonNull private Date endDate;
    @Column(name = "customer_id", nullable = false) @NonNull private int customerId;
    @Column(name = "room_id", nullable = false) @NonNull private int roomId;
    @Column(name = "offer_id") private Integer offerId;
    @Column(name = "final_price", precision = 2) private BigDecimal finalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingsEntity that = (BookingsEntity) o;
        return id == that.id &&
                customerId == that.customerId &&
                roomId == that.roomId &&
                Objects.equals(bookDate, that.bookDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(offerId, that.offerId) &&
                Objects.equals(finalPrice, that.finalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookDate, startDate, endDate, customerId, roomId, offerId, finalPrice);
    }

}
