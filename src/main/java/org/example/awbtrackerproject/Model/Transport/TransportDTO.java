package org.example.awbtrackerproject.Model.Transport;

import java.time.LocalDateTime;

public record TransportDTO(
        Integer id,
        String name,
        Integer sourceHubID,
        Integer destinationHubID,
        LocalDateTime departureTime,
        Integer estimatedDurationHours,
        Double estiamtedFuelUsage,
        Integer intervalNext,
        String status
) {
}
