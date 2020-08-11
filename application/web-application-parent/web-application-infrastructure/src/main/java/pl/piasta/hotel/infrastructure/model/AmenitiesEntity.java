package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "amenities")
@Getter
@Setter
public class AmenitiesEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmenitiesEntity that = (AmenitiesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
