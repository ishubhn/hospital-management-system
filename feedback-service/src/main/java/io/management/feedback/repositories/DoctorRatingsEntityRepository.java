package io.management.feedback.repositories;

import io.management.feedback.entities.DoctorRatingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRatingsEntityRepository extends JpaRepository<DoctorRatingsEntity, String> {
	List<DoctorRatingsEntity> findByDoctorId(String doctorId);
}
