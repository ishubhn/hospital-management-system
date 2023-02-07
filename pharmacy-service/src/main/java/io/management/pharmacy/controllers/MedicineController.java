package io.management.pharmacy.controllers;

import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MedicineResponse;
import io.management.pharmacy.entities.dto.response.MessageResponse;
import io.management.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class MedicineController {

	@Autowired
	private MedicineService service;

	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addNewMedicines(@RequestBody MedicineRequest request) {
		return ResponseEntity.ok(service.addMedicinesInStock(request));
	}

	@GetMapping("/medicines/all")
	public ResponseEntity<List<MedicineResponse>> getAllMedicines() {
		return ResponseEntity.ok(service.getAllMedicines());
	}


}
