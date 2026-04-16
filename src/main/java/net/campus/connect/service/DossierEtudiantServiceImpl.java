package net.campus.connect.service;

import net.campus.connect.model.DossierEtudiant;
import net.campus.connect.repository.DossierEtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierEtudiantServiceImpl implements DossierEtudiantService {

    private final DossierEtudiantRepository repository;

    public DossierEtudiantServiceImpl(DossierEtudiantRepository repository) {
        this.repository = repository;
    }

    @Override
    public DossierEtudiant save(DossierEtudiant dossier) {
        return repository.save(dossier);
    }

    @Override
    public List<DossierEtudiant> getAll() {
        return repository.findAll();
    }

    @Override
    public DossierEtudiant getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier non trouvé avec id: " + id));
    }

    @Override
    public DossierEtudiant getByEtudiant(Integer etudiantId) {
        return repository.findByEtudiantId(etudiantId)
                .orElseThrow(() -> new RuntimeException("Dossier non trouvé pour l'étudiant: " + etudiantId));
    }

    @Override
    public List<DossierEtudiant> getByFiliere(Integer filiereId) {
        return repository.findByFiliereId(filiereId);
    }

 /*   @Override
    public List<DossierEtudiant> getByStatut(DossierEtudiant.StatutDossier statut) {
        return repository.findByStatut(statut);
    }

    @Override
    public DossierEtudiant updateStatut(Integer id, DossierEtudiant.StatutDossier statut) {
        DossierEtudiant dossier = getById(id);
        dossier.setStatut(statut);
        return repository.save(dossier);
    }*/

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}