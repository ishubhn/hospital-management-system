package io.management.hospital.controller;

import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorRequest doctorRequest) {
		return new ResponseEntity<>(doctorService.createDoctor(doctorRequest), HttpStatus.CREATED);
	}
}
