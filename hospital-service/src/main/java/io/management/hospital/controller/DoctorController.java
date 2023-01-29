package io.management.hospital.controller;

import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.DoctorResponse;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/all")
	public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorRequest doctorRequest) {
		return new ResponseEntity<>(doctorService.createDoctor(doctorRequest), HttpStatus.CREATED);
	}
}
