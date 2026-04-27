package net.campus.connect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double valeur;

    private double coefficient;

    @OneToOne
    @JoinColumn(name = "inscription_id")
    private Inscription inscription;


    public Note(Integer id, double valeur, double coefficient, Inscription inscription) {
        this.id = id;
        this.valeur = valeur;
        this.coefficient = coefficient;
        this.inscription = inscription;
    }

    public Note() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
}