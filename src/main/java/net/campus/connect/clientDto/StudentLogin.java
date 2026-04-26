package net.campus.connect.clientDto;

public class StudentLogin {
    private String matricule;
    private String mdp;

    public StudentLogin(String matricule, String mdp) {
        this.matricule = matricule;
        this.mdp = mdp;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
