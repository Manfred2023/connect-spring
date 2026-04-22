package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Filiere;
import net.campus.connect.repository.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereServiceImpl implements FiliereService{

    private  final FiliereRepository repository;

    public FiliereServiceImpl(FiliereRepository repository) {
        this.repository = repository;
    }


    @Override
    public Filiere save(Filiere filiere) {
        return repository.save(filiere);
    }

    @Override
    public List<Filiere> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Filiere> getByNiveau(Integer niveauId) {
        return repository.findByNiveauId(niveauId);
    }

    @Override
    public Filiere getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filiere not found with id: " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
