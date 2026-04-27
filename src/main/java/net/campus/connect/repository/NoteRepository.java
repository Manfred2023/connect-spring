package net.campus.connect.repository;

import net.campus.connect.model.City;
import net.campus.connect.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByInscriptionId(Integer inscriptionId);
}
