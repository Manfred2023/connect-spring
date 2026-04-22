package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.TypeSalle;
import net.campus.connect.repository.CityRepository;
import net.campus.connect.repository.TypeSalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeSalleServiceImpl implements TypeSalleService{

    private final TypeSalleRepository repository;

    public TypeSalleServiceImpl(TypeSalleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TypeSalle save(TypeSalle typeSalle) {
        return repository.save(typeSalle);
    }

    @Override
    public List<TypeSalle> getAll() {
        return repository.findAll();
    }


    public TypeSalle getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TyppeSalle not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
