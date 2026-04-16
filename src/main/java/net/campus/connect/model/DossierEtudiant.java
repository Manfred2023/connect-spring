package net.campus.connect.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dossiers_etudiants")
public class DossierEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @Column(unique = true)
    private String numeroDossier;

    @Column()
    private Boolean isNormalFormation;

    private LocalDate anneAcademique;

    @OneToOne
    @JoinColumn(name = "axe_id")
    private Axe axe ;

    private Boolean status;

    public DossierEtudiant(Integer id, Etudiant etudiant, String numeroDossier, Boolean isNormalFormation, LocalDate anneAcademique, Axe axe, Boolean status) {
        this.id = id;
        this.etudiant = etudiant;
        this.numeroDossier = numeroDossier;
        this.isNormalFormation = isNormalFormation;
        this.anneAcademique = anneAcademique;
        this.axe = axe;
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public Boolean getNormalFormation() {
        return isNormalFormation;
    }

    public void setNormalFormation(Boolean normalFormation) {
        isNormalFormation = normalFormation;
    }

    public LocalDate getAnneAcademique() {
        return anneAcademique;
    }

    public void setAnneAcademique(LocalDate anneAcademique) {
        this.anneAcademique = anneAcademique;
    }

    public Axe getAxe() {
        return axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}