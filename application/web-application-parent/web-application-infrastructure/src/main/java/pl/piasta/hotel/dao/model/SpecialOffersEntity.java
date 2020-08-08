package pl.piasta.hotel.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "special_offers", schema = "public")
public class SpecialOffersEntity {
    private int id;
    private Integer discount;
    private Integer bookingsAmount;
    private String description;

    @Id @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Column(name = "discount") Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public @Column(name = "bookings_amount") Integer getBookingsAmount() {
        return bookingsAmount;
    }

    public void setBookingsAmount(Integer bookingsAmount) {
        this.bookingsAmount = bookingsAmount;
    }

    public @Column(name = "description", length = 100) String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
