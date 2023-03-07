package io.management.feedback.services.impl;

import io.management.feedback.entities.PharmacyRatingEntity;
import io.management.feedback.entities.dto.mapper.DoctorRatingsMapper;
import io.management.feedback.entities.dto.mapper.PharmacyRatingsMapper;
import io.management.feedback.entities.dto.request.DoctorEntityRequest;
import io.management.feedback.entities.dto.request.PharmacyEntityRequest;
import io.management.feedback.entities.dto.response.DoctorRatingsResponse;
import io.management.feedback.entities.dto.response.MessageResponse;
import io.management.feedback.entities.dto.response.PharmacyRatingsResponse;
import io.management.feedback.repositories.DoctorRatingsEntityRepository;
import io.management.feedback.repositories.PharmacyRatingsEntityRepository;
import io.management.feedback.services.DoctorRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorRatingsServiceImpl implements DoctorRatingService {

	@Autowired
	private DoctorRatingsEntityRepository doctorRatingsRepo;

	@Override
	public List<DoctorRatingsResponse> getAllRatingsForDoctor(String doctorId) {
		return doctorRatingsRepo
				.findByDoctorId(doctorId)
				.stream()
				.map(DoctorRatingsMapper::toDoctorRatingsResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<DoctorRatingsResponse> getAllDoctorRatingsFromUser(String userId) {
		return null;
	}

	@Override
	public DoctorRatingsResponse addRatingToDoctor(DoctorEntityRequest request) {
		return null;
	}

	@Override
	public MessageResponse updateRatingsForDoctor(int ratings) {
		return null;
	}

	@Override
	public MessageResponse updateFeedbackForDoctor(String feedback) {
		return null;
	}

	@Override
	public MessageResponse deleteRatingsForDoctor(String ratingId) {
		return null;
	}
}
