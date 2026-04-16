package net.campus.connect.service;

import net.campus.connect.model.DossierEtudiant;
import java.util.List;

public interface DossierEtudiantService {
    DossierEtudiant save(DossierEtudiant dossier);
    List<DossierEtudiant> getAll();
    DossierEtudiant getById(Integer id);
    DossierEtudiant getByEtudiant(Integer etudiantId);
    List<DossierEtudiant> getByFiliere(Integer filiereId);/*
    List<DossierEtudiant> getByStatut(DossierEtudiant.StatutDossier statut);
    DossierEtudiant updateStatut(Integer id, DossierEtudiant.StatutDossier statut);*/
    void delete(Integer id);
}