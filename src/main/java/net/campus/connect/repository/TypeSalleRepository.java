package net.campus.connect.repository;

import net.campus.connect.model.SalleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSalleRepository extends JpaRepository<SalleType, Integer> {
}
