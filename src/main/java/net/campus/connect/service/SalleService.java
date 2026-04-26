package net.campus.connect.service;

import net.campus.connect.model.Country;
import net.campus.connect.model.Salle;

import java.util.List;

public interface SalleService {

    Salle save(Salle salle);
    Salle getById(Integer id);
    List<Salle> getAll();
    void delete(Integer id);
}
