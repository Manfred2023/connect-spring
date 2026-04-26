package net.campus.connect.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("etudiants")
public class Etudiant extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String matricule;

    @Column(nullable = false)
    private String mdp;

    public Etudiant() {}

    public Etudiant(String nom, String prenom, String email, String telephone, City city, String matricule,String mdp) {
        super(nom, prenom, email, telephone, city);
        this.matricule = matricule;
        this.mdp = mdp;
    }


    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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