package io.management.hospital.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
	@Id
	private String addressId;
	private String address;
	private String city;
	private String state;
	private String pinCode;
	private String country;

	public AddressEntity(String address, String city, String state, String pinCode) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
}
