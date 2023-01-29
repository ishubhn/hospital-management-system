package io.management.hospital.service.impl;

import io.management.hospital.entities.DoctorEntity;
import io.management.hospital.entities.dto.mapper.DoctorMapper;
import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.DoctorResponse;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.repositories.DoctorEntityRepository;
import io.management.hospital.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorEntityRepository repo;

	@Override
	public List<DoctorResponse> getAllDoctors() {
		return repo.findAll()
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.collect(Collectors.toList());
	}

	@Override
	public DoctorResponse getDoctorById(String id) {
		return repo.findById(id)
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.findFirst()
				.orElseThrow(() ->
						new NoSuchDoctorEntityException(
								String.format("No doctor entity found with id -> %s", id)
							)
						);
	}

	@Override
	public DoctorResponse getDoctorByEmailId(String emailId) {
		return repo.findByEmailId(emailId)
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.findFirst()
				.orElseThrow(() ->
						new NoSuchDoctorEntityException(
								String.format("No doctor entity found with id -> %s", emailId)
						));
	}

	@Override
	public DoctorResponse getDoctorByName(String firstName, String lastName) {
		return repo.findByFirstNameOrLastName(firstName, lastName)
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.findFirst()
				.orElseThrow(() ->
						new NoSuchDoctorEntityException(
								String.format("No doctor entity found with id -> %s", firstName, lastName)
						));
	}

	@Override
	public List<DoctorResponse> getDoctorsLikeName(String firstName, String lastName) {
		return repo.findByFirstNameOrLastNameContaining(firstName, lastName)
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.collect(Collectors.toList());
	}

	@Override
	public MessageResponse createDoctor(DoctorRequest request) {
		// education details : degree, specialization, diploma
		HashMap<String, String> educationDetailsMap = (HashMap<String, String>) request.getEducationDetails();

		// in postman faced issue with Content type as 'Plain/text'
		// issue was resolved when changed to Content-Type: application/json; charset=utf-8

		// Set
		HashSet<String> enrolledHospitalSet = (HashSet<String>) request.getHospitalsEnrolledIn(); //id of hospital

		DoctorEntity doctorEntity = new DoctorEntity(request.getFirstName(), request.getLastName(), request.getEmailId(),
				request.getContactNumber(), educationDetailsMap, enrolledHospitalSet);

		String doctorId = UUID.randomUUID().toString();

		// Generate and set doctor Id
		doctorEntity.setDoctorId(doctorId);

		log.info(doctorEntity.toString());

		// Save
		repo.save(doctorEntity);

		return new MessageResponse(String.format("Doctor entity created successfully -> %s", request.getEmailId()),
				"SUCCESS");
	}

	@Override
	public MessageResponse enrollDoctorToHospital(String doctorId, String hospitalId) {
		return null;
	}

	@Override
	public MessageResponse addDoctorQualification(String doctorId, String degree, String specializationField) {
		return null;
	}

	@Override
	public MessageResponse deleteDoctor(String doctorId) {
		return null;
	}
}
