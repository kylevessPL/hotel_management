package pl.piasta.hotel.dao.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "public", catalog = "hotel-db")
public class PaymentsEntity {
    private int id;
    private Timestamp paymentDate;
    private int paymentFormId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "payment_date", nullable = false)
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "payment_form_id", nullable = false)
    public int getPaymentFormId() {
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
                paymentFormId == that.paymentFormId &&
                Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDate, paymentFormId);
    }
}
