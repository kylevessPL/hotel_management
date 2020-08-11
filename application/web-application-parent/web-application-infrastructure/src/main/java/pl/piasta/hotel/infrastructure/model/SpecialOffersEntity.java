package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "special_offers")
@Getter
@Setter
public class SpecialOffersEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "bookings_amount")
    private Integer bookingsAmount;
    @Column(name = "description", length = 100)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialOffersEntity that = (SpecialOffersEntity) o;
        return id == that.id &&
                Objects.equals(discount, that.discount) &&
                Objects.equals(bookingsAmount, that.bookingsAmount) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount, bookingsAmount, description);
    }

}
