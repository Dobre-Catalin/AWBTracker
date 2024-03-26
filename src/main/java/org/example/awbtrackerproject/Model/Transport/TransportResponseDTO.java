package org.example.awbtrackerproject.Model.Transport;

public record TransportResponseDTO(
        Integer id,
        String name,
        Integer sourceHubID,
        Integer destinationHubID,
        String departureTime,
        Integer estimatedDurationHours,
        double estiamtedFuelUsage,
        Integer intervalNext,
        String status
) {
}
