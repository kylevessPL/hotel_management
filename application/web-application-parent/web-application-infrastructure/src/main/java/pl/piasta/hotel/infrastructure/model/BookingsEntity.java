package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class BookingsEntity {

    @Id @Column(name = "id", nullable = false) @GeneratedValue(strategy = GenerationType.SEQUENCE)
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


}
