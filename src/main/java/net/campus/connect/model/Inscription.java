package net.campus.connect.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dossier_etudiant_id", nullable = false)
    private DossierEtudiant dossierEtudiant;

    @ManyToOne
    @JoinColumn(name = "groupe_id", nullable = false)
    private Groupe groupe;

    private LocalDate dateInscription;

    // optionnel mais utile
    private boolean statut;
    public Inscription() {}

    public Inscription(Integer id, DossierEtudiant etudiant, Groupe groupe, LocalDate dateInscription, boolean statut) {
        this.id = id;
        this.dossierEtudiant = etudiant;
        this.groupe = groupe;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }
    public Inscription(  DossierEtudiant etudiant, Groupe groupe, LocalDate dateInscription, boolean statut) {
        this.dossierEtudiant = etudiant;
        this.groupe = groupe;
        this.dateInscription = dateInscription;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DossierEtudiant getDossierEtudiant() {
        return dossierEtudiant;
    }

    public void setDossierEtudiant(DossierEtudiant dossierEtudiant) {
        this.dossierEtudiant = dossierEtudiant;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean getStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
}