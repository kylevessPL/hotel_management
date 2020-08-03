package pl.piasta.hotel.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "special_offers", schema = "public", catalog = "hotel-db")
public class SpecialOffersEntity {
    private int id;
    private BigDecimal discount;
    private Integer bookingsAmount;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "discount", nullable = true, precision = 2)
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "bookings_amount", nullable = true)
    public Integer getBookingsAmount() {
        return bookingsAmount;
    }

    public void setBookingsAmount(Integer bookingsAmount) {
        this.bookingsAmount = bookingsAmount;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 100)
    public String getDescription() {
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
