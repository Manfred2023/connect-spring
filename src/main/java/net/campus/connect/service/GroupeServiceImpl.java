package net.campus.connect.service;

import net.campus.connect.model.City;
import net.campus.connect.model.Groupe;
import net.campus.connect.repository.GroupeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository repository;

    public GroupeServiceImpl(GroupeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Groupe create(Groupe groupe) {
        return repository.save(groupe);
    }

    @Override
    public Groupe update(Integer id, Groupe groupe) {

        Groupe existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Groupe not found"));

        existing.setCapMax(groupe.getCapMax());
        existing.setProfesseur(groupe.getProfesseur());
        existing.setGroupeType(groupe.getGroupeType());

        return repository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        Groupe existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Groupe not found"));

        repository.delete(existing);
    }

    @Override
    public List<Groupe> getByCours(Integer countryId) {
        return repository.findByCoursId(countryId);
    }

    @Override
    public Groupe getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Groupe not found"));
    }

    @Override
    public List<Groupe> getAll() {
        return repository.findAll();
    }
}