package io.management.hospital.service.impl;

import io.management.hospital.entities.DoctorEntity;
import io.management.hospital.entities.dto.mapper.DoctorMapper;
import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.DoctorResponse;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.exception.NoSuchDoctorEntityException;
import io.management.hospital.repositories.DoctorEntityRepository;
import io.management.hospital.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorEntityRepository repo;

	private String succesStatus = "SUCCESS";

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
	public List<DoctorResponse> getDoctorsLikeName(String firstName, String lastName) {
		List<DoctorResponse> doctorResponse = repo.findByFirstNameOrLastNameContaining(firstName, lastName)
				.stream()
				.map(DoctorMapper::toDoctorResponse)
				.collect(Collectors.toList());

		if (doctorResponse.isEmpty()) {
			throw new NoSuchDoctorEntityException(
					String.format("No doctor entity found with name -> '%s' or '%s'", firstName, lastName));
		} else {
			return doctorResponse;
		}
	}

	@Override
	public MessageResponse createDoctor(DoctorRequest request) {
		// education details : degree, specialization, diploma
		HashMap<String, String> educationDetailsMap = (HashMap<String, String>) request.getEducationDetails();

		// in postman faced issue with Content type as 'Plain/text'
		// issue was resolved when changed to Content-Type: application/json; charset=utf-8

		// Set
		HashSet<String> enrolledHospitalSet = (HashSet<String>) request.getHospitalsEnrolledIn(); //id of hospital

		DoctorEntity doctorEntity = new DoctorEntity(request.getFirstName(), request.getLastName(),
				request.getEmailId(), request.getContactNumber(), educationDetailsMap, enrolledHospitalSet);

		String doctorId = UUID.randomUUID().toString();

		// Generate and set doctor Id
		doctorEntity.setDoctorId(doctorId);

		log.info(doctorEntity.toString());

		// Save
		repo.save(doctorEntity);

		return new MessageResponse(String.format("Doctor entity created successfully -> %s", request.getEmailId()),
				succesStatus);
	}

	@Override
	public MessageResponse enrollDoctorToHospital(String doctorId, String hospitalId) throws NullPointerException {
		Optional<DoctorEntity> doctorEntity = Optional.ofNullable(repo.findById(doctorId).orElse(null));
		Set<String> hospitalsId = null;

		if (!doctorEntity.isEmpty()) {
			if (doctorEntity.get().getEducationDetails().isEmpty()) {
				hospitalsId.add(hospitalId);
				doctorEntity.get().setHospitalsEnrolledIn(hospitalsId);
			} else {
				// some hospital already exist
				hospitalsId = doctorEntity.get().getHospitalsEnrolledIn();

				if (!hospitalsId.contains(hospitalId)) {
					hospitalsId.add(hospitalId);
				}
			}
			doctorEntity.get().setHospitalsEnrolledIn(hospitalsId);
			repo.save(doctorEntity.get());
		}
		return new MessageResponse(String.format("Doctor -> '%s' enrolled in Hospital -> '%s' successfully",
				doctorId, hospitalId),
				succesStatus);
	}

	@Override
	public MessageResponse addDoctorQualification(String doctorId, String degree, String specializationField) {
		Optional<DoctorEntity> doctorEntity = repo.findById(doctorId);

		if (doctorEntity.isPresent()) {
			Map<String, String> qualificationsMap = doctorEntity.get().getEducationDetails();

			if (qualificationsMap.isEmpty()) {
				qualificationsMap.put(degree, specializationField);
				doctorEntity.get().setEducationDetails(qualificationsMap);
			} else {
				if (!qualificationsMap.containsValue(specializationField)) {
					qualificationsMap.put(degree, specializationField);
					doctorEntity.get().setEducationDetails(qualificationsMap);
				}
			}

			repo.save(doctorEntity.get());
		}
		return new MessageResponse(String.format("Qualification -> ('%s' -> '%s') registered for Doctor -> '%s'" +
						" successfully",
				degree, specializationField, doctorId), succesStatus);
	}

	@Override
	@Transactional
	public MessageResponse deleteDoctor(String doctorId) {
		repo.deleteById(doctorId);
		return new MessageResponse(String.format("Doctor entity with id -> %s is deleted", doctorId), succesStatus);
	}
}
