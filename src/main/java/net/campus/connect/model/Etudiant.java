package net.campus.connect.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("etudiants")
public class Etudiant extends Personne {

    @Column(unique = true,nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String mdp;

    public Etudiant() {}

    public Etudiant(Integer id,String nom, String prenom, String email, String telephone, City city, String matricule,String mdp) {
        super(id, nom, prenom, email, telephone, city);
        this.matricule = matricule;
        this.mdp = mdp;
    }






    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}