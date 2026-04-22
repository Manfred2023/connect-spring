package net.campus.connect.service;
import net.campus.connect.model.TypeSalle;

import java.util.List;

public interface TypeSalleService {
    TypeSalle save(TypeSalle typeSalle);
    List<TypeSalle> getAll();
    TypeSalle getById(Integer id);
    void delete(Integer id);
}
