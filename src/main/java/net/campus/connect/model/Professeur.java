package net.campus.connect.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("professeurs")
public class Professeur extends Personne {

    private Boolean isPermanent;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    private Date dateRecrutement;
    private Integer anciennete;

    @Column(nullable = false)
    private String mdp;

    public Boolean getPermanent() {
        return isPermanent;
    }

    public void setPermanent(Boolean permanent) {
        isPermanent = permanent;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Professeur() {}

    public Professeur(Integer id, String nom, String prenom, String email, String telephone, City city, Boolean isPermanent, Departement departement, Date dateRecrutement, Integer anciennete,String mdp) {
        super(id,nom, prenom, email, telephone, city);
        this.isPermanent = isPermanent;
        this.departement = departement;
        this.dateRecrutement = dateRecrutement;
        this.anciennete = anciennete;
        this.mdp=mdp;
    }


    public Boolean getStatus() {
        return isPermanent;
    }

    public void setStatus(Boolean status) {
        this.isPermanent = status;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }
}