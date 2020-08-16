package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amenities")
@Getter
@Setter
public class AmenitiesEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;

}
