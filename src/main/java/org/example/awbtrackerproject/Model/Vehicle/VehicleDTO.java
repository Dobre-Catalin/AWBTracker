package org.example.awbtrackerproject.Model.Vehicle;

public record VehicleDTO(
        String VIN,
        String registration,
        String make,
        String model,
        Integer year,
        Double displacement,
        Double meanFuelConsumption,
        String category,
        Double height,
        Double length,
        Double width,
        Double grossMass,
        Double maxMass,
        Double cargoWidth,
        Double cargoLength,
        Double cargoHeight,
        Integer ownerHubID,
        Integer assignedTransportID
) {
}
