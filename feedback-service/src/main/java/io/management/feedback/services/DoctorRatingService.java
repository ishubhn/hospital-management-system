package io.management.feedback.services;

import io.management.feedback.entities.dto.request.DoctorEntityRequest;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.DoctorRatingsResponse;
import io.management.feedback.entities.dto.response.MessageResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;

import java.util.List;

public interface DoctorRatingService {
	List<DoctorRatingsResponse> getAllRatingsForDoctor(String doctorId);
	List<DoctorRatingsResponse> getAllDoctorRatingsFromUser(String userId);
	DoctorRatingsResponse addRatingToDoctor(DoctorEntityRequest request);
	MessageResponse updateRatingsForDoctor(int ratings);
	MessageResponse updateFeedbackForDoctor(String feedback);
	MessageResponse deleteRatingsForDoctor(String ratingId);

}
