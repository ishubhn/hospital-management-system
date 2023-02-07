package io.management.pharmacy.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MEDICINE")
public class MedicineEntity {
	@Id
	@Column(nullable = false, updatable = false)
	private String medicineId;

	@NonNull
	private String name;

	@NonNull
	private String companyName;

	@NonNull
	private String medicineContent;

	@Size(min = 0)
	private int quantityInStock;

	private int stripSize;

	private String imageFilePath;

	private boolean isInStock;

	public MedicineEntity(@NonNull String name, @NonNull String companyName, @NonNull String medicineContent,
	                      int quantityInStock, int stripSize, String imageFilePath, boolean isInStock) {
		this.name = name;
		this.companyName = companyName;
		this.medicineContent = medicineContent;
		this.quantityInStock = quantityInStock;
		this.stripSize = stripSize;
		this.imageFilePath = imageFilePath;
		this.isInStock = isInStock;
	}
}
