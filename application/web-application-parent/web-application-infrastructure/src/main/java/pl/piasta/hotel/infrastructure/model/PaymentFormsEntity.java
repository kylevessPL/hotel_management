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

@Entity
@Table(name = "payment_forms")
@Getter
@Setter
public class PaymentFormsEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_forms_generator")
    @SequenceGenerator(name="payment_forms_generator", sequenceName = "seq_payment_forms", allocationSize = 1)
    private Integer id;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

}
