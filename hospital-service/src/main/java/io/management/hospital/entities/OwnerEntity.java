package io.management.hospital.entities;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OWNER")
public class OwnerEntity {
	@Id
	private String ownerId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String emailId;
	@ElementCollection
	private Set<String> hospitalOwnedId;

	public OwnerEntity(String firstName, String lastName, String contactNumber, String emailId,
	                   Set<String> hospitalOwnedId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.hospitalOwnedId = hospitalOwnedId;
	}
}
