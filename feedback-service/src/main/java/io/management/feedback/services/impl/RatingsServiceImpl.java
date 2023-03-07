package io.management.feedback.services.impl;

import io.management.feedback.entities.PharmacyRatingEntity;
import io.management.feedback.entities.dto.mapper.DoctorRatingsMapper;
import io.management.feedback.entities.dto.mapper.PharmacyRatingsMapper;
import io.management.feedback.entities.dto.request.DoctorEntityRequest;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.DoctorRatingsResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;
import io.management.feedback.repositories.DoctorRatingsEntityRepository;
import io.management.feedback.repositories.PharmacyRatingsEntityRepository;
import io.management.feedback.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingsServiceImpl implements RatingService {

	@Autowired
	private DoctorRatingsEntityRepository doctorRatingsRepo;

	@Autowired
	private PharmacyRatingsEntityRepository pharmacyRatingsRepo;

	@Override
	public List<DoctorRatingsResponse> getAllRatingsForDoctor(String doctorId) {
		return doctorRatingsRepo
				.findByDoctorId(doctorId)
				.stream()
				.map(DoctorRatingsMapper::toDoctorRatingsResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<PharmacyRatingsResponse> getAllRatingsForMedicine(String medicineId) {
		return pharmacyRatingsRepo
				.findByMedicineId(medicineId)
				.stream()
				.map(PharmacyRatingsMapper::toPharmacyRatingResponse)
				.collect(Collectors.toList());
	}

	@Override
	public DoctorRatingsResponse addRatingToDoctor(DoctorEntityRequest request) {
		return null;
	}

	@Override
	public PharmacyRatingsResponse addRatingToMedicines(PharmacyEntityRequest request) {
		return null;
	}


}
