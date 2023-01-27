package io.management.hospital.service;

import io.management.hospital.entities.HospitalEntity;
import io.management.hospital.entities.dto.request.HospitalRequest;
import io.management.hospital.entities.dto.response.HospitalResponse;
import io.management.hospital.exception.HospitalAlreadyPresentException;

import java.util.List;

public interface HospitalService {
	List<HospitalEntity> getAllHospitals();

	HospitalResponse createHospital(HospitalRequest hospital) throws HospitalAlreadyPresentException;
}
