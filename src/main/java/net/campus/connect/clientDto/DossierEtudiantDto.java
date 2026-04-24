package net.campus.connect.clientDto;

import java.time.LocalDate;

public class DossierEtudiantDto {
    private String numeroDossier;
    private Integer etudiantId;
    private boolean isFormIni;
    private String anneAcademique;
    private Integer axeId;
    private boolean isCurrent;


    public DossierEtudiantDto(String numeroDossier, Integer etudiantId, boolean isFormIni, String anneAcademique, Integer axeId, boolean isCurrent) {
        this.numeroDossier = numeroDossier;
        this.etudiantId = etudiantId;
        this.isFormIni = isFormIni;
        this.anneAcademique = anneAcademique;
        this.axeId = axeId;
        this.isCurrent = isCurrent;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public DossierEtudiantDto() {
    }

    public String getNumeroDossier() {
        return numeroDossier;
    }

    public void setNumeroDossier(String numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public Integer getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Integer etudiantId) {
        this.etudiantId = etudiantId;
    }

    public boolean isFormIni() {
        return isFormIni;
    }

    public void setFormIni(boolean formIni) {
        isFormIni = formIni;
    }

    public String getAnneAcademique() {
        return anneAcademique;
    }

    public void setAnneAcademique(String anneAcademique) {
        this.anneAcademique = anneAcademique;
    }

    public Integer getAxeId() {
        return axeId;
    }

    public void setAxeId(Integer axeId) {
        this.axeId = axeId;
    }
}
