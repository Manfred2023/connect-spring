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
    @JoinColumn(name = "chief_id")
    private Professeur chief;


    public Departement(Integer id, String name, String sigle, Professeur chief) {
        this.id = id;
        this.name = name;
        this.sigle = sigle;
        this.chief = chief;
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
