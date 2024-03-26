package org.example.awbtrackerproject.Model.Vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Transport.Transport;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    Hub ownerHub;

    @Nullable
    @ManyToOne
    @JsonBackReference
    Transport assignedTransport;

    String VIN;
    String registaration;
    Integer year;
    String make;
    String model;
    Double displacement;
    Double meanFuelConsumption;
    String category;
    Double height;
    Double length;
    Double width;
    Double grossMass;
    Double maxMass;
    Double cargoWidth;
    Double cargoLength;
    Double cargoHeight;

    public Vehicle() {
    }

    public Vehicle(Hub ownerHub, Transport assignedTransport, String VIN, String registaration, Integer year, String make, String model, Double displacement, Double meanFuelConsumption, String category, Double height, Double length, Double width, Double grossMass, Double maxMass, String springType, Double cargoWidth, Double cargoLength, Double cargoHeight) {
        this.ownerHub = ownerHub;
        this.assignedTransport = assignedTransport;
        this.VIN = VIN;
        this.registaration = registaration;
        this.year = year;
        this.make = make;
        this.model = model;
        this.displacement = displacement;
        this.meanFuelConsumption = meanFuelConsumption;
        this.category = category;
        this.height = height;
        this.length = length;
        this.width = width;
        this.grossMass = grossMass;
        this.maxMass = maxMass;
        this.cargoWidth = cargoWidth;
        this.cargoLength = cargoLength;
        this.cargoHeight = cargoHeight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hub getOwnerHub() {
        return ownerHub;
    }

    public void setOwnerHub(Hub ownerHub) {
        this.ownerHub = ownerHub;
    }

    public Transport getAssignedTransport() {
        return assignedTransport;
    }

    public void setAssignedTransport(Transport assignedTransport) {
        this.assignedTransport = assignedTransport;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getRegistaration() {
        return registaration;
    }

    public void setRegistaration(String registaration) {
        this.registaration = registaration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Double getMeanFuelConsumption() {
        return meanFuelConsumption;
    }

    public void setMeanFuelConsumption(Double meanFuelConsumption) {
        this.meanFuelConsumption = meanFuelConsumption;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getGrossMass() {
        return grossMass;
    }

    public void setGrossMass(Double grossMass) {
        this.grossMass = grossMass;
    }

    public Double getMaxMass() {
        return maxMass;
    }

    public void setMaxMass(Double maxMass) {
        this.maxMass = maxMass;
    }

    public Double getCargoWidth() {
        return cargoWidth;
    }

    public void setCargoWidth(Double cargoWidth) {
        this.cargoWidth = cargoWidth;
    }

    public Double getCargoLength() {
        return cargoLength;
    }

    public void setCargoLength(Double cargoLength) {
        this.cargoLength = cargoLength;
    }

    public Double getCargoHeight() {
        return cargoHeight;
    }

    public void setCargoHeight(Double cargoHeight) {
        this.cargoHeight = cargoHeight;
    }
}
