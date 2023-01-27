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
@Table(name = "DOCTOR")
public class DoctorEntity {
	@Id
	private String doctorId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private String educationDetails;
}
