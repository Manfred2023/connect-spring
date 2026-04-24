package net.campus.connect.service;

import net.campus.connect.model.SalleType;
import net.campus.connect.repository.TypeSalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeSalleServiceImpl implements TypeSalleService{

    private final TypeSalleRepository repository;

    public TypeSalleServiceImpl(TypeSalleRepository repository) {
        this.repository = repository;
    }

    @Override
    public SalleType save(SalleType typeSalle) {
        return repository.save(typeSalle);
    }

    @Override
    public List<SalleType> getAll() {
        return repository.findAll();
    }


    public SalleType getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TyppeSalle not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
