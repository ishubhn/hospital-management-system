package io.management.patient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    private String addressId;
    private String addressDetails;
    private String city;
    private String state;
    private String pinCode;
    private static final String COUNTRY = "India";

    public AddressEntity(String addressDetails, String city, String state, String pinCode) {
        this.addressDetails = addressDetails;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }
}
