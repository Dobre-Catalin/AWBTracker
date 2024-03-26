package org.example.awbtrackerproject.Model.Zipcode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Country.Country;
import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Zone.Zone;

@Entity
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    private Zone zone;

    private String zipcode;

    public Zipcode(){

    }

    public Zipcode(String zipcode, Country country){
        this.zipcode = zipcode;
    }
}
