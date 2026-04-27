package net.campus.connect.clientDto;

public class NoteCreateDto {
    private double valeur;
    private Integer coefficient;
    private Integer inscription_id;

    public NoteCreateDto(double valeur, Integer coefficient, Integer inscription_id) {
        this.valeur = valeur;
        this.coefficient = coefficient;
        this.inscription_id = inscription_id;
    }

    public NoteCreateDto() {

    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getInscription_id() {
        return inscription_id;
    }

    public void setInscription_id(Integer inscription_id) {
        this.inscription_id = inscription_id;
    }
}
