package net.campus.connect.service;

import net.campus.connect.model.Inscription;
import net.campus.connect.repository.InscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository repository;

    public InscriptionServiceImpl(InscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inscription inscrire(Inscription inscription) {

        repository.findByDossierEtudiantIdAndGroupeId(
                inscription.getDossierEtudiant().getId(),
                inscription.getGroupe().getId()
        ).ifPresent(i -> {
            throw new RuntimeException("Etudiant déjà inscrit dans ce groupe");
        });

        inscription.setDateInscription(LocalDate.now());
        inscription.setStatut(true);

        return repository.save(inscription);
    }

    @Override
    public void desinscrire(Integer id) {
        Inscription insc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable"));

        repository.delete(insc);
    }

    @Override
    public Inscription getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription introuvable"));
    }

    @Override
    public List<Inscription> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Inscription> getByGroupe(Integer groupeId) {
        return repository.findByGroupeId(groupeId);
    }
}