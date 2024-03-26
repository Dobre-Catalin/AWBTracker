package org.example.awbtrackerproject.Model.Zone;

import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Zipcode.Zipcode;

import java.util.ArrayList;
import java.util.List;

import org.example.awbtrackerproject.Model.Hub.Hub;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    private Hub hubManaging;

    @OneToMany
    private List<Zipcode> zipcodes = new ArrayList<>();
}
