package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue("salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "type_salle_id")
    private TypeSalle typeSalle;
    @Column(unique = true)
    private String code;

    public Salle(Integer id, String name, TypeSalle typeSalle, String code) {
        this.id = id;
        this.name = name;
        this.typeSalle = typeSalle;
        this.code = code;
    }

    public Salle() {
    }

    public TypeSalle getTypeSalle() {
        return typeSalle;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTypeSalle(TypeSalle typeSalle) {
        this.typeSalle = typeSalle;
    }





}
