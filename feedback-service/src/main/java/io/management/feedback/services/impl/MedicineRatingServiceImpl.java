package io.management.feedback.services.impl;

import io.management.feedback.entities.dto.mapper.PharmacyRatingsMapper;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.MessageResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;
import io.management.feedback.repositories.PharmacyRatingsEntityRepository;
import io.management.feedback.services.MedicineRatingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MedicineRatingServiceImpl implements MedicineRatingService {

	@Autowired
	private PharmacyRatingsEntityRepository pharmacyRatingsRepo;

	@Override
	public List<PharmacyRatingsResponse> getAllRatingsForMedicine(String medicineId) {
		return pharmacyRatingsRepo
				.findByMedicineId(medicineId)
				.stream()
				.map(PharmacyRatingsMapper::toPharmacyRatingResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<PharmacyRatingsResponse> getAllMedicineRatingsFromUser(String userId) {
		return null;
	}

	@Override
	public PharmacyRatingsResponse addRatingToMedicines(PharmacyEntityRequest request) {
		return null;
	}

	@Override
	public MessageResponse updateRatingsForMedicine(int ratings) {
		return null;
	}

	@Override
	public MessageResponse updateFeedbackForMedicine(String feedback) {
		return null;
	}

	@Override
	public MessageResponse deleteRatingsForMedicine(String ratingId) {
		return null;
	}
}
