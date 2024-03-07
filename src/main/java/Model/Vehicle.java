package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

enum category{

}

enum springType{

}

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
    Integer axleCount;
    String springType;
    Double cargoWidth;
    Double cargoLength;
    Double cargoHeight;
}
