package org.example.awbtrackerproject.Model.Parcel;

public record ParcelResponseDTO(
        Integer id,
        String sourceAddress,
        String destinationAddress,
        String sourceZIP,
        String destinationZIP,
        Double urgency,
        Boolean fragile,
        Double mass,
        Double height,
        Double width,
        Double length,
        String senderPhoneNumber,
        String recepientPhoneNumber,
        String AWB
) {
}
