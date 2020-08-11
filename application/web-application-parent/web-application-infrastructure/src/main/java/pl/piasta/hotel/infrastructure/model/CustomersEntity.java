package pl.piasta.hotel.infrastructure.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "customers")
@Getter
@Setter
public class CustomersEntity {

    @Id @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column(name = "street_name", nullable = false, length = 30)
    private String streetName;
    @Column(name = "house_number", nullable = false)
    private int houseNumber;
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;
    @Column(name = "city", nullable = false, length = 30)
    private String city;
    @Column(name = "document_type", nullable = false, length = 10)
    private String documentType;
    @Column(name = "document_id", nullable = false, length = 10)
    private String documentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return id == that.id &&
                houseNumber == that.houseNumber &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(streetName, that.streetName) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(city, that.city) &&
                Objects.equals(documentType, that.documentType) &&
                Objects.equals(documentId, that.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, streetName, houseNumber, zipCode, city, documentType, documentId);
    }

}
