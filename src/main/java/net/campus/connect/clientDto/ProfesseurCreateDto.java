package net.campus.connect.clientDto;

import java.util.Date;

public class ProfesseurCreateDto {
    private boolean isPermanent;
    private Integer departementId;
    private Date dateRecrutement;
    private Integer anciennete;
    private String mdp;

    //personne information
    private String nom;
    private String prenom;
    private String email;
    private String mobile;
    private Integer cityId;

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public ProfesseurCreateDto(boolean isPermanent, Integer departement, Date dateRecrutement, Integer anciennete, String nom, String prenom, String email, String mobile, Integer cityId, String mdp) {
        this.isPermanent = isPermanent;
        this.departementId = departement;
        this.dateRecrutement = dateRecrutement;
        this.anciennete = anciennete;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mobile = mobile;
        this.cityId = cityId;
        this.mdp=mdp;
    }


    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public Integer getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Integer departementId) {
        this.departementId = departementId;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
