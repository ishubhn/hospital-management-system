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

	@GetMapping("/search/all")
	public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@GetMapping("/search/id/{id}")
	public ResponseEntity<DoctorResponse> getDoctorDetailsById(@PathVariable String id) {
		return ResponseEntity.ok(doctorService.getDoctorById(id));
	}

	@GetMapping("/search/id/{emailId}")
	public ResponseEntity<DoctorResponse> getDoctorDetailsByEmail(@PathVariable String emailId) {
		return ResponseEntity.ok(doctorService.getDoctorByEmailId(emailId));
	}

	@GetMapping("/search/name")
	public ResponseEntity<List<DoctorResponse>> getDoctorDetailsByEitherName
			(@RequestParam String firstName, @RequestParam String lastName) {
		return ResponseEntity.ok(doctorService.getDoctorsLikeName(firstName, lastName));
	}

	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorRequest doctorRequest) {
		return new ResponseEntity<>(doctorService.createDoctor(doctorRequest), HttpStatus.CREATED);
	}

	@PostMapping("/add/{doctorId}/{hospitalId}")
	public ResponseEntity<MessageResponse> enrollDoctorToHospital(@PathVariable String doctorId,
	                                                              @PathVariable String addressId) {
		return new ResponseEntity<>(doctorService.enrollDoctorToHospital(doctorId, addressId),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MessageResponse> deleteDoctorById(@PathVariable String id) {
		return new ResponseEntity<>(doctorService.deleteDoctor(id), HttpStatus.OK);
	}
}
