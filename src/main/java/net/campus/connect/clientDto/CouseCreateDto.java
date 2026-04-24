package net.campus.connect.clientDto;

public class CouseCreateDto {
    private String intitule;
    private String code;
    private String description;
    private Integer volume_horaire_en_heure;
    private Integer credit;
    private Integer professeur_id;
    private Integer departement_id;

    public CouseCreateDto(String intitule, String code, String description, Integer volume_horaire_en_heure, Integer credit, Integer professeur_id, Integer departement_id) {
        this.intitule = intitule;
        this.code = code;
        this.description = description;
        this.volume_horaire_en_heure = volume_horaire_en_heure;
        this.credit = credit;
        this.professeur_id = professeur_id;
        this.departement_id = departement_id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
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

    public Integer getVolume_horaire_en_heure() {
        return volume_horaire_en_heure;
    }

    public void setVolume_horaire_en_heure(Integer volume_horaire_en_heure) {
        this.volume_horaire_en_heure = volume_horaire_en_heure;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getProfesseur_id() {
        return professeur_id;
    }

    public void setProfesseur_id(Integer professeur_id) {
        this.professeur_id = professeur_id;
    }

    public Integer getDepartement_id() {
        return departement_id;
    }

    public void setDepartement_id(Integer departement_id) {
        this.departement_id = departement_id;
    }
}
