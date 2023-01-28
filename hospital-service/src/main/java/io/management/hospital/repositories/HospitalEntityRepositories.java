package io.management.hospital.repositories;

import io.management.hospital.entities.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalEntityRepositories extends JpaRepository<HospitalEntity, String> {
	Optional<HospitalEntity> findByEmailId(String emailId);
	Optional<HospitalEntity> deleteByEmailId(String emailId);
//	Optional<HospitalEntity> findByPincode(String pinCode);
}
