package io.management.pharmacy.entities.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineResponse {
	private String medicineId;

	private String name;

	private String companyName;

	private String medicineContent;

	private int quantityInStock;

	private int stripSize;

	private String filePath;

	private boolean inStock;
}
