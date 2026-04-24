package net.campus.connect.repository;

import net.campus.connect.model.Country;
import net.campus.connect.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
