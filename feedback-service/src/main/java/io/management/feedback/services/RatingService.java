package io.management.feedback.services;

import io.management.feedback.entities.dto.request.DoctorEntityRequest;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.DoctorRatingsResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;

import java.util.List;

public interface RatingService {
	List<DoctorRatingsResponse> getAllRatingsForDoctor(String doctorId);
	List<PharmacyRatingsResponse> getAllRatingsForMedicine(String pharmacyId);
	DoctorRatingsResponse addRatingToDoctor(DoctorEntityRequest request);
	PharmacyRatingsResponse addRatingToMedicines(PharmacyEntityRequest request);
}
