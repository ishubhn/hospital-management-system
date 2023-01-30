package io.management.hospital.service;

import io.management.hospital.entities.dto.request.OwnerRequest;
import io.management.hospital.entities.dto.response.MessageResponse;
import io.management.hospital.entities.dto.response.OwnerResponse;

import java.util.List;

public interface OwnerService {
	public MessageResponse addOwner(OwnerRequest request);

	public List<OwnerResponse> getAllOwnersByHospitalId(String hospitalId);

	public OwnerResponse getOwnerById(String id);

	MessageResponse assignHospitaltoOwner(String ownerId, String hospitalId);

	MessageResponse removeOwnerById(String id);
}
