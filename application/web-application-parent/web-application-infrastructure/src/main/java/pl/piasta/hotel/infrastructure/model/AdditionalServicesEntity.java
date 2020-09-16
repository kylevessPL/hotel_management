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
import java.math.BigDecimal;

@Entity
@Table(name = "additional_services")
@Getter
@Setter
public class AdditionalServicesEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "additional_services_generator")
    @SequenceGenerator(name="additional_services_generator", sequenceName = "seq_additional_services", allocationSize = 1)
    private Integer id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "price", precision = 2)
    private BigDecimal price;

}
