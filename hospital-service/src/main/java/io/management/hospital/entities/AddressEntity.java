package io.management.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
	@Id
	private String addressId;
	private String address;
	private String city;
	private String state;
	private final String COUNTRY = "INDIA";
}
