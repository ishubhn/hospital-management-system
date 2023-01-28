package io.management.hospital.entities;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.Set;

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
	@ElementCollection          // To handle collection inside JPA entity (JPA2 approach)
	private Map<String, String> educationDetails;    // Key -> Graduation, Specialization (MBBS - General, MD -> Ortho)
	@ElementCollection
	private Set<String> hospitalsEnrolledIn;


	public DoctorEntity(String firstName, String lastName, String emailId, String contactNumber, Map<String,
			String> educationDetails, Set<String> hospitalsEnrolledIn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.educationDetails = educationDetails;
		this.hospitalsEnrolledIn = hospitalsEnrolledIn;
	}
}
