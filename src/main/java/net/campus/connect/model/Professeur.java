package net.campus.connect.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue("professeurs")
public class Professeur extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isPermanent;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    private Date dateRecrutement;
    private Integer anciennete;

    public Professeur() {}


    public Professeur(Integer id, Boolean status, String email, Departement departement, Date dateRecrutement, Integer anciennete) {
        this.id = id;
        this.isPermanent = status;
        this.email = email;
        this.departement = departement;
        this.dateRecrutement = dateRecrutement;
        this.anciennete = anciennete;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return isPermanent;
    }

    public void setStatus(Boolean status) {
        this.isPermanent = status;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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