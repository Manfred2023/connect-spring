package net.campus.connect.repository;
import net.campus.connect.model.City;
import net.campus.connect.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
    List<Filiere> findByNiveauId(Integer niveauId);
}
