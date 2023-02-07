package io.management.pharmacy.services.impl;

import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MessageResponse;
import io.management.pharmacy.services.MedicineService;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {
	@Override
	public MessageResponse addMedicinesInStock(MedicineRequest medicine) {
		return null;
	}
}
