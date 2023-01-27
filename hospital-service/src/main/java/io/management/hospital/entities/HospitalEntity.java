package io.management.hospital.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HOSPITAL")
public class HospitalEntity {
	@Id
	private String hospitalId;
	private String name;

	@OneToOne(cascade = CascadeType.ALL)     //  This very important, else throws entityNotFoundException
	@JoinColumn(name = "address_address_id")
	private AddressEntity address;

	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private String password;

	public HospitalEntity(String name, AddressEntity address, String contactNumber, String alternateContactNumber,
	                      String emailId, String password ) {
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.emailId = emailId;
		this.password = password;
	}
}
