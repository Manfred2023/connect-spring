package net.campus.connect.repository;

import net.campus.connect.model.Salle;
import net.campus.connect.model.TypeSalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository  extends JpaRepository<Salle, Integer> {
}
