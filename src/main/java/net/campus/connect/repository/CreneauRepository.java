package net.campus.connect.repository;

import net.campus.connect.enums.Jour;
import net.campus.connect.enums.Periode;
import net.campus.connect.model.Creneau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreneauRepository extends JpaRepository<Creneau, Integer> {

    Optional<Creneau> findByJourAndPeriode(Jour jour, Periode periode);
}