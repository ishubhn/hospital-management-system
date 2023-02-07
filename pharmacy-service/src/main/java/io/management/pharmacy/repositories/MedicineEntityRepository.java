package io.management.pharmacy.repositories;

import io.management.pharmacy.entities.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MedicineEntityRepository extends JpaRepository<MedicineEntity, String> {
	Set<MedicineEntity> findByNameContaining(String name);
}
