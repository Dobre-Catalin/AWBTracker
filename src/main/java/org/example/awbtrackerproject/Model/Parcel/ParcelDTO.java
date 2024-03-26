package org.example.awbtrackerproject.Model.Parcel;

public record ParcelDTO(
        Double mass,
        Double height,
        Double width,
        Double length,
        Boolean fragile,
        Boolean paidForFastDelivery,
        Integer sourceZIP,
        Integer destinationZIP,
        String sourceAddress,
        String destinationAddress,
        String senderPhoneNumber,
        String recepientPhoneNumber,
        Integer userSendingID
) {
}
