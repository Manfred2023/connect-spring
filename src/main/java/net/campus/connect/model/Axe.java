package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@Table(name = "axes")
public class Axe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String intitule;

    private String description;

    @Column(unique = true)
    private String sigle;
    private Integer capMax;

    @OneToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    public Axe(Integer id, String intitule, String description, String sigle, Integer capMax, Filiere filiere) {
        this.id = id;
        this.intitule = intitule;
        this.description = description;
        this.sigle = sigle;
        this.capMax = capMax;
        this.filiere = filiere;
    }

    public Axe() {
    }


    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }
}
