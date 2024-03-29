package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import pl.piasta.hotel.domain.model.bookings.utils.BookingStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class BookingsEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_generator")
    @SequenceGenerator(name="bookings_generator", sequenceName = "seq_bookings", allocationSize = 1)
    private Integer id;
    @Column(name = "book_date", nullable = false)
    private Timestamp bookDate;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Column(name = "room_id", nullable = false)
    private Integer roomId;
    @Column(name = "offer_id")
    private Integer offerId;
    @Column(name = "final_price", precision = 2)
    private BigDecimal finalPrice;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.NOT_CONFIRMED;

}
