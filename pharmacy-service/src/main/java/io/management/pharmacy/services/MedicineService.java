package io.management.pharmacy.services;

import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MedicineResponse;
import io.management.pharmacy.entities.dto.response.MessageResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MedicineService {
	MessageResponse addMedicinesInStock(MedicineRequest medicine);

	List<MedicineResponse> getAllMedicines();

	Set<MedicineResponse> getMedicineLikeName(String name);

	Map<String, String> getMedicineByComposition(String composition);
}
