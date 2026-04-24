package net.campus.connect.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dossiers_etudiants")
public class DossierEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;

    @Column(unique = true, nullable = false)
    private String numeroDossier;

    @Column()
    private Boolean isNormalFormation;

    @Column(nullable = false)
    private String anneAcademique;

    @ManyToOne
    @JoinColumn(name = "axe_id", nullable = false)
    private Axe axe ;

    @Column(nullable = false)
    private Boolean isCurrent;

    private float moyenneGenerale;

    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }

    public float getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(float moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public DossierEtudiant(Etudiant etudiant, String numeroDossier, Boolean isNormalFormation, String anneAcademique, Axe axe, Boolean status) {
        this.etudiant = etudiant;
        this.numeroDossier = numeroDossier;
        this.isNormalFormation = isNormalFormation;
        this.anneAcademique = anneAcademique;
        this.axe = axe;
        this.isCurrent = status;
    }

    public DossierEtudiant() {
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

    public String getAnneAcademique() {
        return anneAcademique;
    }

    public void setAnneAcademique(String anneAcademique) {
        this.anneAcademique = anneAcademique;
    }

    public Axe getAxe() {
        return axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Boolean getStatus() {
        return isCurrent;
    }

    public void setStatus(Boolean status) {
        this.isCurrent = status;
    }
}