package io.management.hospital.entities.dto.response;

import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {
	private String doctorId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private Map<String, String> educationDetails;
	private Set<String> hospitalsEnrolledIn;
}
