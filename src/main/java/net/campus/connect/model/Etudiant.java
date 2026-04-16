package net.campus.connect.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("etudiants")
public class Etudiant extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String matricule;
    private String mdp;

    public Etudiant() {}

    public Etudiant(String nom, String prenom, String email, String telephone, City city, String matricule) {
        super(nom, prenom, email, telephone, city);
        this.matricule = matricule;
    }


    public Etudiant(String matricule) {
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}