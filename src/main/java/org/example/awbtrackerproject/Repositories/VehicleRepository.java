package org.example.awbtrackerproject.Repositories;

import org.example.awbtrackerproject.Model.Vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>
{
}
