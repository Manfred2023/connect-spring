package net.campus.connect.service;

import net.campus.connect.model.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant save(Etudiant etudiant);
    List<Etudiant> getAll();
    Etudiant getById(Integer id);
    Etudiant getByMatricule(String matricule);
   /* List<Etudiant> getByFiliere(String filiere);
    List<Etudiant> getByNiveau(int niveau);*/
    void delete(Integer id);
}