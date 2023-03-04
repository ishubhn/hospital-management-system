package io.management.patient.external.services;

import io.management.patient.external.dto.Hospital;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "HOSPITAL-SERVICE")
public interface HospitalService {
	@GetMapping("/search/all")
	List<Hospital> getAllHospitals();
}