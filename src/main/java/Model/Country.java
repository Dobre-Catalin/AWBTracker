package Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String name;
    String code;
    Integer vignette;

    public Country(String name, String code, Integer vignette) {
        this.name = name;
        this.code = code;
        this.vignette = vignette;
    }

    ///one to many, one country has many hubs
    @OneToMany(mappedBy = "hub", cascade = CascadeType.ALL)
    private List<Hub> hubs = new ArrayList<>();

    public Country() {

    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", code=" + code + '}';
    }
}
