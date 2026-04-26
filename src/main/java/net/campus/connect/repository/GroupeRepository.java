package net.campus.connect.repository;

import net.campus.connect.model.City;
import net.campus.connect.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
    List<Groupe> findByCoursId(Integer coursId);
}