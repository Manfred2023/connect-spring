package net.campus.connect.repository;

import net.campus.connect.model.GroupeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupeTypeRepository extends JpaRepository<GroupeType, Integer> {

    Optional<GroupeType> findByCode(String code);

    Optional<GroupeType> findByLabel(String label);
}