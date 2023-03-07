package io.management.feedback.entities.dto.mapper;

import io.management.feedback.entities.PharmacyRatingEntity;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;

public class PharmacyRatingsMapper {

	private PharmacyRatingsMapper() {}

	private static PharmacyRatingEntity toPharmacyRatingsEntity(PharmacyEntityRequest request) {
		return new PharmacyRatingEntity(request.getMedicineId(), request.getUserId(), request.getRatings(),
				request.getFeedback());
	}

	public static PharmacyRatingsResponse toPharmacyRatingResponse(PharmacyRatingEntity entity) {
		return new PharmacyRatingsResponse(entity.getRatingsId(), entity.getMedicineId(), entity.getUserId(),
				entity.getRatings(), entity.getFeedback());
	}
}
