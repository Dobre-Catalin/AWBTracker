package org.example.awbtrackerproject.Model.Transport;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.example.awbtrackerproject.Model.Hub.Hub;
import org.example.awbtrackerproject.Model.Vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Nullable
    @OneToMany(
            mappedBy = "assignedTransport",
            cascade = CascadeType.ALL
    )
    private List<Vehicle> assignedVehicles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @OneToOne
    Hub sourceHub;
    @OneToOne
    Hub destinationHub;

    LocalDateTime departureTime;
    Integer estimatedDurationHours;
    Double estiamtedFuelUsage;
    @Nullable
    Integer intervalNext;
    String status;

    public Transport() {
    }

    public Transport(String name, Hub sourceHub, Hub destinationHub, LocalDateTime departureTime, Integer estimatedDurationHours, Double estiamtedFuelUsage, @Nullable Integer intervalNext, String status) {
        this.name = name;
        this.sourceHub = sourceHub;
        this.destinationHub = destinationHub;
        this.departureTime = departureTime;
        this.estimatedDurationHours = estimatedDurationHours;
        this.estiamtedFuelUsage = estiamtedFuelUsage;
        this.intervalNext = intervalNext;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehicle> getAssignedVehicles() {
        return assignedVehicles;
    }

    public void setAssignedVehicles(List<Vehicle> assignedVehicles) {
        this.assignedVehicles = assignedVehicles;
    }

    public Hub getSourceHub() {
        return sourceHub;
    }

    public void setSourceHub(Hub sourceHub) {
        this.sourceHub = sourceHub;
    }

    public Hub getDestinationHub() {
        return destinationHub;
    }

    public void setDestinationHub(Hub destinationHub) {
        this.destinationHub = destinationHub;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getEstimatedDurationHours() {
        return estimatedDurationHours;
    }

    public void setEstimatedDurationHours(Integer estimatedDurationHours) {
        this.estimatedDurationHours = estimatedDurationHours;
    }

    public Double getEstiamtedFuelUsage() {
        return estiamtedFuelUsage;
    }

    public void setEstiamtedFuelUsage(Double estiamtedFuelUsage) {
        this.estiamtedFuelUsage = estiamtedFuelUsage;
    }

    public Integer getIntervalNext() {
        return intervalNext;
    }

    public void setIntervalNext(Integer intervalNext) {
        this.intervalNext = intervalNext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addVehicle(Vehicle vehicle){
        assignedVehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        assignedVehicles.remove(vehicle);
    }

    public void clearVehicles(){
        assignedVehicles.clear();
    }

    public Transport renewTransport(){

        LocalDateTime newDepartureTime = departureTime.plusDays(intervalNext);

        return new Transport(name, sourceHub, destinationHub, newDepartureTime, estimatedDurationHours, estiamtedFuelUsage, intervalNext, "waiting");
    }

}
