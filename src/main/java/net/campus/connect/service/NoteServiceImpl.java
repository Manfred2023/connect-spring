package net.campus.connect.service;

import net.campus.connect.model.Note;
import net.campus.connect.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository repository;

    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note save(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Note> getByInscriptionId(Integer inscriptionId) {
        return repository.findByInscriptionId(inscriptionId);
    }

    @Override
    public Note getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
