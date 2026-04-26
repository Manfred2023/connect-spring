package net.campus.connect.repository;

import net.campus.connect.model.City;
import net.campus.connect.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

    Optional<Inscription> findByDossierEtudiantIdAndGroupeId(Integer etudiantId, Integer groupeId);
    List<Inscription> findByGroupeId(Integer groupeId);
    List<Inscription> findByDossierEtudiantId(Integer etudiantId);
}