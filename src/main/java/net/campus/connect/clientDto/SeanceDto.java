package net.campus.connect.clientDto;

public class SeanceDto {
    private Integer groupe;
    private Integer salle;
    private Integer creneau;


    public SeanceDto(Integer groupe, Integer salle, Integer creneau) {
        this.groupe = groupe;
        this.salle = salle;
        this.creneau = creneau;
    }

    public SeanceDto() {
    }

    public Integer getGroupe() {
        return groupe;
    }

    public void setGroupe(Integer groupe) {
        this.groupe = groupe;
    }

    public Integer getSalle() {
        return salle;
    }

    public void setSalle(Integer salle) {
        this.salle = salle;
    }

    public Integer getCreneau() {
        return creneau;
    }

    public void setCreneau(Integer creneau) {
        this.creneau = creneau;
    }
}
