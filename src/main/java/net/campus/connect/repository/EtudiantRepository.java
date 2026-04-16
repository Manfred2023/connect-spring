package net.campus.connect.repository;

import net.campus.connect.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    Optional<Etudiant> findByMatricule(String matricule);
    List<Etudiant> findByFiliere(String filiere);
    List<Etudiant> findByNiveau(int niveau);
}