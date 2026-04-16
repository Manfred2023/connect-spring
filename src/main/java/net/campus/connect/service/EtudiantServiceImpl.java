package net.campus.connect.service;

import net.campus.connect.model.Etudiant;
import net.campus.connect.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository repository;

    public EtudiantServiceImpl(EtudiantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAll() {
        return repository.findAll();
    }

    @Override
    public Etudiant getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
    }

    @Override
    public Etudiant getByMatricule(String matricule) {
        return repository.findByMatricule(matricule)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with matricule: " + matricule));
    }

    @Override
    public List<Etudiant> getByFiliere(String filiere) {
        return repository.findByFiliere(filiere);
    }

    @Override
    public List<Etudiant> getByNiveau(int niveau) {
        return repository.findByNiveau(niveau);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}