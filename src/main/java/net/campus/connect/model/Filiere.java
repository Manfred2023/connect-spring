package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@Table(name = "filieres")
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String sigle;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }


    public Filiere(Integer id, String name, String sigle) {
        this.id = id;
        this.name = name;
        this.sigle = sigle;
    }

    public Filiere() {
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
}
