package net.campus.connect.repository;

import net.campus.connect.model.City;
import net.campus.connect.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository  extends JpaRepository<Cours, Integer> {
    List<Cours> findByDepartementId(Integer departementId);
}
