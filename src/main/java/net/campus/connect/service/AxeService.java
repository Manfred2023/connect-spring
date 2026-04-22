package net.campus.connect.service;

import net.campus.connect.model.Axe;
import net.campus.connect.model.City;
import net.campus.connect.repository.AxeRepository;

import java.util.List;

public interface AxeService {
    Axe save(Axe axe);
    List<Axe> getAll();
    List<Axe> getByFiliere(Integer filiereId);
    Axe getById(Integer id);
    void delete(Integer id);
}
