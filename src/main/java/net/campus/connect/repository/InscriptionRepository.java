package net.campus.connect.repository;

import net.campus.connect.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

    Optional<Inscription> findByEtudiantIdAndGroupeId(Integer etudiantId, Integer groupeId);
}