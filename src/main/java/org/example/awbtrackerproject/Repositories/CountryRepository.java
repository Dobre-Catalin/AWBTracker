package org.example.awbtrackerproject.Repositories;

import org.example.awbtrackerproject.Model.Country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>{
}
