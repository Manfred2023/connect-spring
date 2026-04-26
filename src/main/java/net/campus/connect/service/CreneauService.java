package net.campus.connect.service;

import net.campus.connect.model.Creneau;

import java.util.List;

public interface CreneauService {

    Creneau create(Creneau creneau);

    List<Creneau> getAll();

    Creneau getById(Integer id);
}
