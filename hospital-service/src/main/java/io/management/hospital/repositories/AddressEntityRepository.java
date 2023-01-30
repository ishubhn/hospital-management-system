package io.management.hospital.repositories;

import io.management.hospital.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity, String> {
}
