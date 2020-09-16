package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import pl.piasta.hotel.domain.model.customers.utils.DocumentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class CustomersEntity {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_generator")
    @SequenceGenerator(name="customers_generator", sequenceName = "seq_customers", allocationSize = 1)
    private Integer id;
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column(name = "street_name", nullable = false, length = 30)
    private String streetName;
    @Column(name = "house_number", nullable = false, length = 10)
    private String houseNumber;
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;
    @Column(name = "city", nullable = false, length = 30)
    private String city;
    @Column(name = "document_type", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    @Column(name = "document_id", nullable = false, length = 10)
    private String documentId;

}
