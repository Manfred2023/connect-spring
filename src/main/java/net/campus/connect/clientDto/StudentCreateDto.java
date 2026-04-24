package net.campus.connect.clientDto;

public class StudentCreateDto {
    private String matricule;
    private String mdp;
    private String nom;
    private String prenom;
    private String email;
    private String mobile;
    private Integer cityId;


    public StudentCreateDto(String matricule, String mdp, String nom, String prenom, String email,String mobile, Integer cityId) {
        this.matricule = matricule;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mobile = mobile;
        this.cityId = cityId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public StudentCreateDto() {
    }

    public String getMatricul() {
        return matricule;
    }

    public void setMatricul(String matricul) {
        this.matricule = matricul;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
