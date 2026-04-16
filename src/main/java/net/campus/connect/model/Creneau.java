package net.campus.connect.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "creneau")
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String day;
    private Date start_at;
    private Date end_at;

    public Creneau(Integer id, String day, Date start_at, Date end_at) {
        this.id = id;
        this.day = day;
        this.start_at = start_at;
        this.end_at = end_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getStart_at() {
        return start_at;
    }

    public void setStart_at(Date start_at) {
        this.start_at = start_at;
    }

    public Date getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Date end_at) {
        this.end_at = end_at;
    }
}