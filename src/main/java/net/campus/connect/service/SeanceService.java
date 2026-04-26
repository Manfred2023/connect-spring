package net.campus.connect.service;

import net.campus.connect.model.Groupe;
import net.campus.connect.model.Seance;

import java.util.List;

public interface SeanceService {

    Seance create(Seance seance);

    List<Seance> getAll();
    List<Seance> findByGroupeId(Integer groupeId);
    List<Seance> findByGroupeIn(List<Groupe> groupes);

    Seance getById(Integer id);

    void delete(Integer id);
}
