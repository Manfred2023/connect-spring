    package net.campus.connect.model;


    import jakarta.persistence.*;

    @Entity
    @Table(name = "cours")
    public class Cours {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String intitule;

        @Column(unique = true, nullable = false)
        private String code;
        private String description;
        private int volume_horaire_en_heure;
        private int credit;

        @ManyToOne
        @JoinColumn(name = "professeur_id")
        private Professeur professeur;

        @ManyToOne
        @JoinColumn(name = "departement_id")
        private Departement departement;

        public Departement getDepartement() {
            return departement;
        }

        public void setDepartement(Departement departement) {
            this.departement = departement;
        }

        public Professeur getProfesseur() {
            return professeur;
        }

        public void setProfesseur(Professeur professeur) {
            this.professeur = professeur;
        }

        public Cours(  String intitule, String code, String description, int volumeHoraireEnHeure, int credit, Professeur professeur, Departement departement) {
            this.intitule = intitule;
            this.code = code;
            this.description = description;
            this.volume_horaire_en_heure = volumeHoraireEnHeure;
            this.credit = credit;
            this.professeur = professeur;
            this.departement = departement;
        }

        public Cours( ) {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public int getVolumeHoraireEnHeure() {
            return volume_horaire_en_heure;
        }

        public void setVolumeHoraireEnHeure(int volumeHoraireEnHeure) {
            this.volume_horaire_en_heure = volumeHoraireEnHeure;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }
    }
