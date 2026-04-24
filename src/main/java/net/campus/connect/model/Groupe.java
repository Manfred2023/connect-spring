package net.campus.connect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "groupes")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer capMax;
    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "groupe_type_id")
    private GroupeType groupeType;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public GroupeType getGroupeType() {
        return groupeType;
    }

    public void setGroupeType(GroupeType groupeType) {
        this.groupeType = groupeType;
    }

    public Groupe(  Integer capMax, Professeur professeur, GroupeType groupeType, Cours cours) {

        this.capMax = capMax;
        this.professeur = professeur;
        this.groupeType = groupeType;
        this.cours = cours;
    }

    public Groupe( ) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
