package org.example.awbtrackerproject.Model.User;

public record UserDTO(
        String email,
        String password,
        Boolean isAdmin,
        Boolean isSender,
        Boolean isViewOnly
) {

}
