package pl.piasta.hotel.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "customers", schema = "public")
public class CustomersEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String streetName;
    private int houseNumber;
    private String zipCode;
    private String city;
    private String documentType;
    private String documentId;

    public @Id @Column(name = "id", nullable = false) int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Column(name = "first_name", nullable = false, length = 30) String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @Column(name = "last_name", nullable = false, length = 30) String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @Column(name = "street_name", nullable = false, length = 30) String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public @Column(name = "house_number", nullable = false) int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public @Column(name = "zip_code", nullable = false, length = 10) String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public @Column(name = "city", nullable = false, length = 30) String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public @Column(name = "document_type", nullable = false, length = 10) String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public @Column(name = "document_id", nullable = false, length = 10) String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

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
