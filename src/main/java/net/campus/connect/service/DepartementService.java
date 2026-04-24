package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Departement;

import java.util.List;

public interface DepartementService {
    Departement save(Departement departement);
    List<Departement> getAll();
    Departement getById(Integer id);
    void delete(Integer id);
}
