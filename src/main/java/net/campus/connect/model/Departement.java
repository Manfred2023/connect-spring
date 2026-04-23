package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@Table(name = "departement")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String sigle;

    @OneToOne
    @JoinColumn(name = "chief_id", nullable = true)
    private Professeur chief;

    @OneToOne
    @JoinColumn(name = "filiere_id", unique = true)
    private Filiere filiere;


    public Departement(  String name, String sigle, Professeur chief, Filiere filiere) {

        this.name = name;
        this.sigle = sigle;
        this.chief = chief;
        this.filiere = filiere;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Departement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public Professeur getChief() {
        return chief;
    }

    public void setChief(Professeur chief) {
        this.chief = chief;
    }
}
