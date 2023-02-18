package io.management.pharmacy.entities.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineResponse {
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
