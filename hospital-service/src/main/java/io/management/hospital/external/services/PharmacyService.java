package io.management.hospital.external.services;

import io.management.hospital.external.dto.Medicine;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PHARMACY-SERVICE")
public interface PharmacyService {
	@GetMapping("/medicines/all")
	List<Medicine> getAllMedicines();
}