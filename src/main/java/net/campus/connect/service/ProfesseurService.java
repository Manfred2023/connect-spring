package net.campus.connect.service;

import net.campus.connect.model.Professeur;

import java.util.List;

public interface ProfesseurService {
    Professeur save(Professeur professeur);
    List<Professeur> getAll();
    Professeur getById(Integer id);
   // List<Professeur> getBySpecialite(String specialite);
    //List<Professeur> getByGrade(String grade);
    void delete(Integer id);
}