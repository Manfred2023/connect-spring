package net.campus.connect.service;

import net.campus.connect.model.Note;

import java.util.List;

public interface NoteService {
    Note save(Note note);
    List<Note> getAll();
    List<Note> getByInscriptionId(Integer inscriptionId);
    Note getById(Integer id);
    void delete(Integer id);
}
