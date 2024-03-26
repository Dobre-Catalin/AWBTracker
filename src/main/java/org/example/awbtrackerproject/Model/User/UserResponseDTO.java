package org.example.awbtrackerproject.Model.User;

public record UserResponseDTO(
        String email,
        String password,
        Boolean isAdmin,
        Boolean isSender,
        Boolean isViewOnly,
        Integer id) {
}
