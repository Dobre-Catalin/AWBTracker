package org.example.awbtrackerproject.Repositories;

import org.example.awbtrackerproject.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
