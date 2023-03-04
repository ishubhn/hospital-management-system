package io.management.patient.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
	private String doctorId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNumber;
	private Map<String, String> educationDetails;
	// fetch hospitals first, then add to set in the service and then return
	private Set<Hospital> hospitalsEnrolledIn;
}