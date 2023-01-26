package io.management.hospital.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TABLE")
public class HospitalEntity {
	@Id
	private String hospitalId;
	private String name;

	@OneToOne
	@JoinColumn(name = "address_address_id")
	private AddressEntity address;
	
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private String password;
}
