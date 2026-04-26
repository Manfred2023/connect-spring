package net.campus.connect.service;

import net.campus.connect.model.Cours;

import java.util.List;

public interface CoursService {

    Cours save(Cours cours);
    List<Cours> getAll();
    List<Cours> getByDepartementId(Integer departementId);
    Cours getById(Integer id);
    void delete(Integer id);
}
