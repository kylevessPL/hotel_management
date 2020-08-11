package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "payments")
@Getter
@Setter
public class PaymentsEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "booking_id", nullable = false)
    private int bookingId;
    @Column(name = "payment_date", nullable = false)
    private Timestamp paymentDate;
    @Column(name = "payment_form_id", nullable = false)
    private int paymentFormId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentsEntity that = (PaymentsEntity) o;
        return id == that.id &&
                bookingId == that.bookingId &&
                paymentFormId == that.paymentFormId &&
                Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, paymentDate, paymentFormId);
    }

}
