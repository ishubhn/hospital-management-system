package io.management.pharmacy.services.impl;

import io.management.pharmacy.entities.MedicineEntity;
import io.management.pharmacy.entities.dto.mapper.MedicineMapper;
import io.management.pharmacy.entities.dto.request.MedicineRequest;
import io.management.pharmacy.entities.dto.response.MedicineResponse;
import io.management.pharmacy.entities.dto.response.MessageResponse;
import io.management.pharmacy.repositories.MedicineEntityRepository;
import io.management.pharmacy.services.MedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.management.pharmacy.entities.dto.mapper.MedicineMapper.toMedicineEntity;

@Service
@Slf4j
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineEntityRepository repo;

	@Override
	public MessageResponse addMedicinesInStock(MedicineRequest medicine) {
		String message = null;
		String statusType = "FAILURE";

		if (medicine != null) {
			String id = UUID.randomUUID().toString();
			MedicineEntity entity = toMedicineEntity(medicine);
			entity.setMedicineId(id);
			repo.save(entity);
			message = "Medicine saved successfully -> " + id;
			statusType = "SUCCESS";
		} else {
			message = "Medicine request passed in is empty or null";
		}
		return new MessageResponse(message, statusType);
	}

	@Override
	public List<MedicineResponse> getAllMedicines() {
		return repo.findAll()
				.stream()
				.map(MedicineMapper::toMedicineResponse)
				.collect(Collectors.toList());
	}

	@Override
	public Set<MedicineResponse> getMedicineLikeName(String name) {
		return repo.findByNameContaining(name).stream().map(MedicineMapper::toMedicineResponse)
				.collect(Collectors.toSet());
	}

	@Override
	public Map<String, String> getMedicineByComposition(String composition) {
		return null;
	}


}
