package io.management.feedback.services;

import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.MessageResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;

import java.util.List;

public interface MedicineRatingService {
	List<PharmacyRatingsResponse> getAllRatingsForMedicine(String pharmacyId);
	List<PharmacyRatingsResponse> getAllMedicineRatingsFromUser(String userId);
	PharmacyRatingsResponse addRatingToMedicines(PharmacyEntityRequest request);
	MessageResponse updateRatingsForMedicine(int ratings);
	MessageResponse updateFeedbackForMedicine(String feedback);
	MessageResponse deleteRatingsForMedicine(String ratingId);
}
