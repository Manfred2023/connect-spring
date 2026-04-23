package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Departement;
import net.campus.connect.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService{

    private final DepartementRepository repository;

    public DepartementServiceImpl(DepartementRepository repository) {
        this.repository = repository;
    }


    @Override
    public Departement save(Departement departement) {
        return repository.save(departement);
    }

    @Override
    public List<Departement> getAll() {
        return repository.findAll();
    }

    @Override
    public Departement getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departement not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
