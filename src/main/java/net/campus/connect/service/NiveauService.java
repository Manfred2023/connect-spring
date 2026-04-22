package net.campus.connect.service;

import net.campus.connect.model.Country;
import net.campus.connect.model.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau save(Niveau niveau);
    List<Niveau> getAll();
}

