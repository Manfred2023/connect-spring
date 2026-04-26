package net.campus.connect.service;

import net.campus.connect.exception.ConflitHoraireException;
import net.campus.connect.model.Groupe;
import net.campus.connect.model.Seance;
import net.campus.connect.repository.SeanceRepository;
import net.campus.connect.service.SeanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository repository;

    public SeanceServiceImpl(SeanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Seance create(Seance seance) {

        List<Seance> seances = repository.findByCreneau(seance.getCreneau());

        for (Seance s : seances) {

            if (s.getSalle().getId().equals(seance.getSalle().getId())) {
                throw new ConflitHoraireException("Salle déjà occupée pour ce créneau");
            }

            if (s.getGroupe().getId().equals(seance.getGroupe().getId())) {
                throw new ConflitHoraireException("Groupe déjà occupé pour ce créneau");
            }

            if (s.getGroupe().getProfesseur().getId()
                    .equals(seance.getGroupe().getProfesseur().getId())) {
                throw new ConflitHoraireException("Professeur déjà occupé pour ce créneau");
            }
        }

        return repository.save(seance);
    }

    @Override
    public List<Seance> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Seance> findByGroupeId(Integer groupeId) {
        return repository.findByGroupeId(groupeId);
    }

    @Override
    public List<Seance> findByGroupeIn(List<Groupe> groupes) {
        return repository.findByGroupeIn(groupes);
    }

    @Override
    public Seance getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Séance introuvable"));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}