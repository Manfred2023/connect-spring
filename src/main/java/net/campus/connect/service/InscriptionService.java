package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Inscription;
import net.campus.connect.model.Note;

import java.util.List;

public interface InscriptionService {

    Inscription inscrire(Inscription inscription);
    //Note addStudentNote(Note note);

    void desinscrire(Integer id);

    Inscription getById(Integer id);

    List<Inscription> getAll();

    List<Inscription> getByGroupe(Integer groupeId);

    List<Inscription> findByDossierEtudiantId(Integer dossierEtudiantId);
}