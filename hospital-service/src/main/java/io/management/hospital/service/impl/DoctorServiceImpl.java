package io.management.hospital.service.impl;

import io.management.hospital.entities.dto.mapper.DoctorMapper;
import io.management.hospital.entities.dto.request.DoctorRequest;
import io.management.hospital.entities.dto.response.DoctorResponse;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.repositories.DoctorEntityRepository;
import io.management.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
		return null;
	}

	@Override
	public DoctorResponse getDoctorByName(String name) {
		return null;
	}

	@Override
	public List<DoctorResponse> getDoctorsLikeName(String name) {
		return null;
	}

	@Override
	public MessageResponse createDoctor(DoctorRequest request) {
		return null;
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
