package io.management.pharmacy.controllers;

import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MedicineResponse;
import io.management.pharmacy.entities.dto.response.MessageResponse;
import io.management.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

	@GetMapping("/medicines/{name}")
	public ResponseEntity<Set<MedicineResponse>> getAllMedicinesLikeName(@PathVariable String name) {
		return ResponseEntity.ok(service.getMedicineLikeName(name));
	}

	@GetMapping("/medicines/composition/{content}")
	public ResponseEntity<List<MedicineResponse>> getAllMedicinesByComposition(@PathVariable String content) {
		return ResponseEntity.ok(service.getMedicineByComposition(content));
	}

	@PutMapping("/medicines/{medicineId}")
	public ResponseEntity<MedicineResponse> deactivateMedicinesInStock(@PathVariable String medicineId) {
		return ResponseEntity.ok(service.deactivateMedicines(medicineId));
	}
}
