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
    @JoinColumn(name = "salle_types_id")
    private SalleType typeSalle;

    @Column(unique = true)
    private String code;

    private Integer max;

    public Salle() {
    }

    public Salle(Integer id, String name, SalleType typeSalle, String code, Integer max) {
        this.id = id;
        this.name = name;
        this.typeSalle = typeSalle;
        this.code = code;
        this.max = max;
    }

    public SalleType getTypeSalle() {
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

    public void setTypeSalle(SalleType typeSalle) {
        this.typeSalle = typeSalle;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
