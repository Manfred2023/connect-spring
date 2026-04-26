package net.campus.connect.repository;

import net.campus.connect.model.Seance;
import net.campus.connect.model.Creneau;
import net.campus.connect.model.Salle;
import net.campus.connect.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

    List<Seance> findByCreneau(Creneau creneau);

    List<Seance> findBySalleAndCreneau(Salle salle, Creneau creneau);

    List<Seance> findByGroupeAndCreneau(Groupe groupe, Creneau creneau);

    List<Seance> findByGroupeId(Integer groupeId);

    List<Seance> findByGroupeIn(List<Groupe> groupes);
}