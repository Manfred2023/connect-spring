package net.campus.connect.repository;

import net.campus.connect.model.Axe;
import net.campus.connect.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AxeRepository extends JpaRepository<Axe, Integer> {
    List<Axe> findByFiliereId(Integer filiereId);
}

