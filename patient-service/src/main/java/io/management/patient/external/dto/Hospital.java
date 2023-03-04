package io.management.patient.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	private String hospitalId;
	private String name;
	private Address address;
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
}