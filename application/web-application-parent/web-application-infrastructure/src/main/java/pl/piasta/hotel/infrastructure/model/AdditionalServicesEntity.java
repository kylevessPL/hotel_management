package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "additional_services")
@Getter
@Setter
public class AdditionalServicesEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 40)
    private String name;
    @Column(name = "price", precision = 2)
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalServicesEntity that = (AdditionalServicesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

}
