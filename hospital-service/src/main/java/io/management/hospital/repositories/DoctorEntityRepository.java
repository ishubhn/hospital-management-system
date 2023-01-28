package io.management.hospital.repositories;

import io.management.hospital.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, String> {
}
