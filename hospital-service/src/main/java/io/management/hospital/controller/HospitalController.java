package io.management.hospital.controller;

import io.management.hospital.entities.HospitalEntity;
import io.management.hospital.entities.dto.request.HospitalRequest;
import io.management.hospital.entities.dto.response.HospitalResponse;
import io.management.hospital.exception.HospitalAlreadyPresentException;
import io.management.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/search/all")
	public ResponseEntity<List<HospitalEntity>> getAllHospitals() {
		return ResponseEntity.ok(hospitalService.getAllHospitals());
	}

	@PostMapping("/add")
	public ResponseEntity<HospitalResponse> createHospital(@RequestBody HospitalRequest request)
			throws HospitalAlreadyPresentException {
		return ResponseEntity.ok(hospitalService.createHospital(request));
	}
}
