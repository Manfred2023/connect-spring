package net.campus.connect.service;

import net.campus.connect.model.Inscription;

import java.util.List;

public interface InscriptionService {

    Inscription inscrire(Inscription inscription);

    void desinscrire(Integer id);

    Inscription getById(Integer id);

    List<Inscription> getAll();
}