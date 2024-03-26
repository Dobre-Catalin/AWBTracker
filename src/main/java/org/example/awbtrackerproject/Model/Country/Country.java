package org.example.awbtrackerproject.Model.Country;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import org.example.awbtrackerproject.Model.Hub.Hub;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    Integer vignette;

    ///one country has many hubs
    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Hub> hubs = new ArrayList<>();

    public Country(String name, Integer vignette) {
        this.name = name;
        this.vignette = vignette;
    }


    public Country() {

    }

    public String getName() {
        return name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVignette() {
        return vignette;
    }

    public void setVignette(Integer vignette) {
        this.vignette = vignette;
    }

    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", vignette=" + vignette +'}';
    }
}
