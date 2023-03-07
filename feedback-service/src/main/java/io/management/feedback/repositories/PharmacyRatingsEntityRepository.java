package io.management.feedback.repositories;

import io.management.feedback.entities.PharmacyRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRatingsEntityRepository extends JpaRepository<PharmacyRatingEntity, String> {
	List<PharmacyRatingEntity> findByMedicineId(String medicineId);
}
