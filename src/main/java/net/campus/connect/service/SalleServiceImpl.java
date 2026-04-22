package net.campus.connect.service;

import net.campus.connect.model.Salle;
import net.campus.connect.repository.CountryRepository;
import net.campus.connect.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService{

    private final SalleRepository repository;

    public SalleServiceImpl(SalleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Salle save(Salle salle) {
        return repository.save(salle);
    }

    @Override
    public List<Salle> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
