package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Groupe;

import java.util.List;

public interface GroupeService {

    Groupe create(Groupe groupe);

    Groupe update(Integer id, Groupe groupe);

    List<Groupe> getByCours(Integer coursId);

    void delete(Integer id);

    Groupe getById(Integer id);

    List<Groupe> getAll();
}