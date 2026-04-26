package net.campus.connect.clientDto;

public class DepartementDTO {

    private Integer id;
    private String nom;

    private Integer chefId;
    private String chefNom;


    public DepartementDTO(Integer id, String nom, Integer chefId, String chefNom) {
        this.id = id;
        this.nom = nom;
        this.chefId = chefId;
        this.chefNom = chefNom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }

    public String getChefNom() {
        return chefNom;
    }

    public void setChefNom(String chefNom) {
        this.chefNom = chefNom;
    }
}