package net.campus.connect.model;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue("type_groupes")
public class GroupeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String label;

    @Column(unique = true, nullable = false)
    private String code;
    private String description;

    public GroupeType(Integer id, String label, String code, String description) {
        this.id = id;
        this.label = label;
        this.code = code;
        this.description = description;
    }

    public GroupeType( ) {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
