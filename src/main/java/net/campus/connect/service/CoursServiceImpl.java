package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Cours;
import net.campus.connect.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class CoursServiceImpl implements CoursService{

    private final CoursRepository repository;

    public CoursServiceImpl(CoursRepository repository) {
        this.repository = repository;
    }


    @Override
    public Cours save(Cours cours) {
        return repository.save(cours);
    }

    @Override
    public List<Cours> getAll() {
        return repository.findAll();
    }


    @Override
    public List<Cours> getByDepartementId(Integer departementId) {
        return repository.findByDepartementId(departementId);
    }

    public Cours getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
