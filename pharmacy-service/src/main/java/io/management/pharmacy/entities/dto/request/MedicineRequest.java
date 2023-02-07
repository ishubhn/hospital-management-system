package io.management.pharmacy.entities.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineRequest {
	private String name;

	private String companyName;

	private String medicineContent;

	private int quantityInStock;

	private int stripSize;

	private String imageFilePath;

	private boolean inStock;

	public MedicineRequest(String name, String companyName, String medicineContent, int quantityInStock,
	                       int stripSize, String imageFilePath) {
		this.name = name;
		this.companyName = companyName;
		this.medicineContent = medicineContent;
		this.quantityInStock = quantityInStock;
		this.stripSize = stripSize;
		this.imageFilePath = imageFilePath;
		this.inStock = false;
	}
}
