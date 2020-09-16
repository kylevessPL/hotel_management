package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class PaymentsEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_generator")
    @SequenceGenerator(name="payments_generator", sequenceName = "seq_payments", allocationSize = 1)
    private Integer id;
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;
    @Column(name = "payment_date", nullable = false)
    private Timestamp paymentDate;
    @Column(name = "payment_form_id", nullable = false)
    private Integer paymentFormId;

}
