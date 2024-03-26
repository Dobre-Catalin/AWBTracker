package org.example.awbtrackerproject.Repositories;

import org.example.awbtrackerproject.Model.Zipcode.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipcodeRepository extends JpaRepository<Zipcode, Integer> {
}
