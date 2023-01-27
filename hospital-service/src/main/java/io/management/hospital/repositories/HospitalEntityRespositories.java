package io.management.hospital.repositories;

import io.management.hospital.entities.HospitalEntity;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalEntityRespositories extends JpaRepository<HospitalEntity, String> {
	Optional<HospitalEntity> findByEmailId(String emailId);
}
