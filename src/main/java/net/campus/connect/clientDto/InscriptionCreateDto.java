package net.campus.connect.clientDto;

public class InscriptionCreateDto {
    private Integer dossier_etudiant_id;
    private Integer groupe_id;


    public InscriptionCreateDto(Integer dossier_etudiant_id, Integer groupe_id) {
        this.dossier_etudiant_id = dossier_etudiant_id;
        this.groupe_id = groupe_id;
    }

    public Integer getDossier_etudiant_id() {
        return dossier_etudiant_id;
    }

    public void setDossier_etudiant_id(Integer dossier_etudiant_id) {
        this.dossier_etudiant_id = dossier_etudiant_id;
    }

    public Integer getGroupe_id() {
        return groupe_id;
    }

    public void setGroupe_id(Integer groupe_id) {
        this.groupe_id = groupe_id;
    }
}
