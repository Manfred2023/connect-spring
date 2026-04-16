package net.campus.connect.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String dialCode;

    @Column(unique = true)
    private String alpha2;

    @Column(unique = true)
    private String alpha3;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country( ) {}

    public Country(Integer id, String name, String dialCode, String alph2, String alph3) {
        this.id = id;
        this.name = name;
        this.dialCode = dialCode;
        this.alpha2 = alph2;
        this.alpha3 = alph3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }
}
