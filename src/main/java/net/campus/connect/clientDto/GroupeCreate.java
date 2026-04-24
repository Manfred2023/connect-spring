package net.campus.connect.clientDto;

public class GroupeCreate {
    private Integer capMax;
    private Integer professeur_id;
    private Integer groupe_type_id;
    private Integer cours_id;

    public GroupeCreate(Integer capMax, Integer professeur_id, Integer groupe_type_id, Integer cours_id) {
        this.capMax = capMax;
        this.professeur_id = professeur_id;
        this.groupe_type_id = groupe_type_id;
        this.cours_id = cours_id;
    }

    public Integer getCours_id() {
        return cours_id;
    }

    public void setCours_id(Integer cours_id) {
        this.cours_id = cours_id;
    }

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    public Integer getProfesseur_id() {
        return professeur_id;
    }

    public void setProfesseur_id(Integer professeur_id) {
        this.professeur_id = professeur_id;
    }

    public Integer getGroupe_type_id() {
        return groupe_type_id;
    }

    public void setGroupe_type_id(Integer groupe_type_id) {
        this.groupe_type_id = groupe_type_id;
    }
}
