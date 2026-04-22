package net.campus.connect.service;


import net.campus.connect.model.Axe;
import net.campus.connect.repository.AxeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AxeServiceImpl implements AxeService{

    private final AxeRepository repository;

    public AxeServiceImpl(AxeRepository repository) {
        this.repository = repository;
    }


    @Override
    public Axe save(Axe axe) {
        return repository.save(axe);
    }

    @Override
    public List<Axe> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Axe> getByFiliere(Integer filiereId) {
        return repository.findByFiliereId(filiereId);
    }

    @Override
    public Axe getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Axe not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
