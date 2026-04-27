package net.campus.connect.model;

public class MoyenneEtudiant {
    private double moyenne;
    private DossierEtudiant dossierEtudiant;

    public MoyenneEtudiant(double moyenne, DossierEtudiant dossierEtudiant) {
        this.moyenne = moyenne;
        this.dossierEtudiant = dossierEtudiant;
    }

    public MoyenneEtudiant( ) {

    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public DossierEtudiant getDossierEtudiant() {
        return dossierEtudiant;
    }

    public void setDossierEtudiant(DossierEtudiant dossierEtudiant) {
        this.dossierEtudiant = dossierEtudiant;
    }
}
