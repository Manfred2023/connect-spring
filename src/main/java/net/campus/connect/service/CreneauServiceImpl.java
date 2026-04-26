package net.campus.connect.service;

import net.campus.connect.model.Creneau;
import net.campus.connect.repository.CreneauRepository;
import net.campus.connect.service.CreneauService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreneauServiceImpl implements CreneauService {

    private final CreneauRepository repository;

    public CreneauServiceImpl(CreneauRepository repository) {
        this.repository = repository;
    }

    @Override
    public Creneau create(Creneau creneau) {

        repository.findByJourAndPeriode(
                creneau.getJour(),
                creneau.getPeriode()
        ).ifPresent(c -> {
            throw new RuntimeException("Ce créneau existe déjà");
        });

        return repository.save(creneau);
    }

    @Override
    public List<Creneau> getAll() {
        return repository.findAll();
    }

    @Override
    public Creneau getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creneau introuvable"));
    }
}