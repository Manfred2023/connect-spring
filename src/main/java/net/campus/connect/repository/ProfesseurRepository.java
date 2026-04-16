package net.campus.connect.repository;

import net.campus.connect.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
    List<Professeur> findBySpecialite(String specialite);
    List<Professeur> findByGrade(String grade);
}