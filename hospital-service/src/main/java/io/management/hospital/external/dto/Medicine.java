package io.management.hospital.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
	private String medicineId;
	private String name;
	private String companyName;
	private Map<String, String> medicineContent;
	private String medicineType;
	private int quantityInStock;
	private int stripSize;
	private String filePath;
	private boolean inStock;
}