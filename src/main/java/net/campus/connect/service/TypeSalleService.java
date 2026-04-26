package net.campus.connect.service;
import net.campus.connect.model.SalleType;

import java.util.List;

public interface TypeSalleService {
    SalleType save(SalleType typeSalle);
    List<SalleType> getAll();
    SalleType getById(Integer id);
    void delete(Integer id);
}
