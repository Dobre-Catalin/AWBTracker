package org.example.awbtrackerproject.Model.Hub;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Country.Country;
import org.example.awbtrackerproject.Model.Vehicle.Vehicle;
import org.example.awbtrackerproject.Model.Zone.Zone;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String name;
    String zipcode;
    String address;

    @OneToMany(
            mappedBy = "ownerHub",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Vehicle> vehicles = new ArrayList<>();

    @Nullable
    @JsonBackReference
    @OneToMany(
            mappedBy = "hubManaging",
            cascade = CascadeType.ALL
    )
    private List<Zone> zones = new ArrayList<>();

    @ManyToOne
    private Country country;

    public Hub(){

    }

    public Hub(String name, String zipcode, String address, Country country){
        this.name = name;
        this.zipcode = zipcode;
        this.address=address;
        this.country = country;
        this.zones = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
