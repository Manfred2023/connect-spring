package net.campus.connect.clientDto;

public class DepartementCreateDto {
    private Integer professeurId;
    private Integer filiereId;

    public DepartementCreateDto(  Integer professeurId, Integer filiereId) {
        this.professeurId = professeurId;
        this.filiereId = filiereId;
    }


    public Integer getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Integer professeurId) {
        this.professeurId = professeurId;
    }

    public Integer getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Integer filiereId) {
        this.filiereId = filiereId;
    }
}
