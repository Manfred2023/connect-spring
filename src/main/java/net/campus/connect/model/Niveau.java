package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@Table(name = "niveaux")
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String valeur;
    private Integer credit;

    public Niveau(Integer id) {
        this.id = id;
    }

    public Niveau(Integer id, String valeur, Integer credit) {
        this.id = id;
        this.valeur = valeur;
        this.credit = credit;
    }

    public Niveau() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
