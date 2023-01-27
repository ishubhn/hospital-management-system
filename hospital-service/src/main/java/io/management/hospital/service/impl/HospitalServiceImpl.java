package io.management.hospital.service.impl;

import io.management.hospital.entities.AddressEntity;
import io.management.hospital.entities.HospitalEntity;
import io.management.hospital.entities.dto.mapper.HospitalMapper;
import io.management.hospital.entities.dto.request.HospitalRequest;
import io.management.hospital.entities.dto.response.HospitalResponse;
import io.management.hospital.exception.HospitalAlreadyPresentException;
import io.management.hospital.repositories.HospitalEntityRespositories;
import io.management.hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.management.hospital.entities.dto.mapper.HospitalMapper.toHospitalResponse;

@Service
@Slf4j
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalEntityRespositories hospitalRepo;

	@Override
	public List<HospitalEntity> getAllHospitals() {
		return hospitalRepo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public HospitalResponse createHospital(HospitalRequest hospital) throws HospitalAlreadyPresentException {
/*		if (hospital != null) {

			String hospitalId = UUID.randomUUID().toString();
			String hospitalAddressId = UUID.randomUUID().toString();
			HospitalEntity hospitalEntity = HospitalMapper.toHospitalEntity(hospital);
			hospitalEntity.setHospitalId(hospitalId);
			hospitalEntity.getAddress().setAddressId(hospitalAddressId);

			try {
				hospitalRepo.save(hospitalEntity);
			} catch (Exception e) {
//				System.err.println(e.printStackTrace());
				System.err.println("error at saving hospital");
				e.printStackTrace();
			}

			return new MessageResponse(
					String.format("Hospital '%s' created successfully", hospital.getEmailId()),
					"SUCCESS");
		}
		return new MessageResponse(
				String.format("Hospital '%s' creation failed", hospital.getEmailId()),
				"ERROR");*/

		if (isHospitalPresent(hospital.getEmailId())) {
			throw new HospitalAlreadyPresentException(String.format("Hospital '%s' already exist", hospital.getEmailId()));
		} else {
			// User Entity
			String uuid = UUID.randomUUID().toString();
			String addressUuid = UUID.randomUUID().toString();
			log.info(HospitalMapper.toHospitalEntity(hospital).toString());
			HospitalEntity hospitalEntity = HospitalMapper.toHospitalEntity(hospital);
			hospitalEntity.setHospitalId(uuid);
			log.info("Hospital Id -> " + hospitalEntity.getHospitalId());

			// Address Entity
			AddressEntity addressEntity = hospitalEntity.getAddress();
			addressEntity.setAddressId(addressUuid);
			log.info("Address Id -> " + hospitalEntity.getAddress().getAddressId());
			log.info("After setting id's");
			log.info(HospitalMapper.toHospitalEntity(hospital).toString());
			log.info(hospitalEntity.toString());
			hospitalRepo.save(hospitalEntity);

			log.info("");
			log.info("User %s created successfully", hospital.getEmailId());
			return toHospitalResponse(HospitalMapper.toHospitalEntity(hospital));
//			return null;
		}
	}

	public boolean isHospitalPresent(String emailId) {
		HospitalEntity user = hospitalRepo.findByEmailId(emailId).orElse(null);
		return user != null;  //true = user is not null
	}
}
