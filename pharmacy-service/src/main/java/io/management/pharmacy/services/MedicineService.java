package io.management.pharmacy.services;

import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MessageResponse;

public interface MedicineService {
	MessageResponse addMedicinesInStock(MedicineRequest medicine);
}
