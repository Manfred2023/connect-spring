package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Filiere;

import java.util.List;

public interface FiliereService {

    Filiere save(Filiere filiere);
    List<Filiere> getAll();
    List<Filiere> getByNiveau(Integer niveauId);
    Filiere getById(Integer id);
    void delete(Integer id);
}
