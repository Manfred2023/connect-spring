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
    @JoinColumn(name = "etudiant_id", nullable = false)
    private DossierEtudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "groupe_id", nullable = false)
    private Groupe groupe;

    private LocalDate dateInscription;

    // optionnel mais utile
    private String statut; // ACTIF, SUSPENDU, etc.

    public Inscription() {}

    public Inscription(Integer id, DossierEtudiant etudiant, Groupe groupe, LocalDate dateInscription, String statut) {
        this.id = id;
        this.etudiant = etudiant;
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

    public DossierEtudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(DossierEtudiant etudiant) {
        this.etudiant = etudiant;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}