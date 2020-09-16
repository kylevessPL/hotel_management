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
@Table(name = "amenities")
@Getter
@Setter
public class AmenitiesEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "amenities_generator")
    @SequenceGenerator(name="amenities_generator", sequenceName = "seq_amenities", allocationSize = 1)
    private Integer id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;

}
