package net.campus.connect.repository;

import net.campus.connect.model.DossierEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DossierEtudiantRepository extends JpaRepository<DossierEtudiant, Integer> {
    Optional<DossierEtudiant> findByEtudiantId(Integer etudiantId);
    //List<DossierEtudiant> findByFiliereId(Integer filiereId);
    //List<DossierEtudiant> findByNiveau(int niveau);
}