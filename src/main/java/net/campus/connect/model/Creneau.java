package net.campus.connect.model;

import jakarta.persistence.*;
import net.campus.connect.enums.Jour;
import net.campus.connect.enums.Periode;

import java.util.Date;


@Entity
@Table(name = "creneaux",uniqueConstraints = @UniqueConstraint(columnNames = {"jour", "periode"}))
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Jour jour;

    @Enumerated(EnumType.STRING)
    private Periode periode;

    public Creneau() {}

    public Creneau(Integer id, Jour jour, Periode periode) {
        this.id = id;
        this.jour = jour;
        this.periode = periode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jour getJour() {
        return jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
}