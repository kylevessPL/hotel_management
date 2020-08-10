package pl.piasta.hotel.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "amenities", schema = "public")
public class AmenitiesEntity {
    private int id;
    private String name;

    public @Id @Column(name = "id", nullable = false) int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Column(name = "name", nullable = false, length = 40) String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
