package pl.piasta.hotel.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "payments", schema = "public")
public class PaymentsEntity {
    private int id;
    private int bookingId;
    private Timestamp paymentDate;
    private int paymentFormId;

    public @Id @Column(name = "id", nullable = false) int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Column(name = "booking_id", nullable = false) int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public @Column(name = "payment_date", nullable = false) Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public @Column(name = "payment_form_id", nullable = false) int getPaymentFormId() {
        return paymentFormId;
    }

    public void setPaymentFormId(int paymentFormId) {
        this.paymentFormId = paymentFormId;
    }

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
