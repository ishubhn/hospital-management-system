package io.management.pharmacy.entities.dto.response;

import io.management.pharmacy.external.dto.Ratings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
	private List<Ratings> ratings;
	private String filePath;
	private boolean inStock;

	public MedicineResponse(String medicineId, String name, String companyName,
	                        Map<String, String> medicineContent, String medicineType,
	                        int quantityInStock, int stripSize, String filePath, boolean inStock) {
		this.medicineId = medicineId;
		this.name = name;
		this.companyName = companyName;
		this.medicineContent = medicineContent;
		this.medicineType = medicineType;
		this.quantityInStock = quantityInStock;
		this.stripSize = stripSize;
		this.filePath = filePath;
		this.inStock = inStock;
	}
}
