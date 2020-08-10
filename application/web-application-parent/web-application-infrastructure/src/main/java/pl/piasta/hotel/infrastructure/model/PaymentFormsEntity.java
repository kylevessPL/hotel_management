package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "payment_forms")
@Getter
@Setter
public class PaymentFormsEntity {

    @Id @Column(name = "id", nullable = false) @NonNull private int id;
    @Column(name = "name", nullable = false, length = 10) @NonNull private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentFormsEntity that = (PaymentFormsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
