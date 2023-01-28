package io.management.hospital.service;

import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.DoctorResponse;
import io.management.hospital.entities.dto.response.MessageResponse;

import java.util.List;

public interface DoctorService {
	List<DoctorResponse> getAllDoctors();

	DoctorResponse getDoctorById(String id);

	DoctorResponse getDoctorByEmailId(String emailId);

	DoctorResponse getDoctorByName(String name);

	List<DoctorResponse> getDoctorsLikeName(String name);

	MessageResponse createDoctor(DoctorRequest request);

	MessageResponse enrollDoctorToHospital(String doctorId, String hospitalId);

	MessageResponse addDoctorQualification(String doctorId, String degree, String specializationField);

	MessageResponse deleteDoctor(String doctorId);
}
